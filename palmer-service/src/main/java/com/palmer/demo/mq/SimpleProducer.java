package com.palmer.demo.mq;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/12/25, at 下午8:48
 * @Modified by:
 * @Description:
 */
@Component
public class SimpleProducer implements InitializingBean, DisposableBean{

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleProducer.class);

    @Setter
    private String nameServerAddress;
    @Setter
    private String application;
    @Setter
    private String topic;
    @Setter
    private long defaultTimeout = 3000;//默认3秒

    private DefaultMQProducer producer;


    /**
     * 发送消息。使用默认的topic和超时时间
     * @param message
     * @return
     * @throws MQException
     */
    public SendResult sendMessage(StringMessage message) throws MQException{
        return sendMessage(this.topic, message, defaultTimeout);
    }

    /**
     * 发送消息。使用默认的topic
     * @param message
     * @param timeoutInMilliSeconds
     * @return
     * @throws MQException
     */
    public SendResult sendMessage(StringMessage message, long timeoutInMilliSeconds) throws MQException{
        return sendMessage(this.topic, message, timeoutInMilliSeconds);
    }

    /**
     * 发送消息。使用默认的超时时间
     * @param topic
     * @param message
     * @return
     * @throws MQException
     */
    public SendResult sendMessage(String topic, StringMessage message) throws MQException{
        return sendMessage(topic, message, this.defaultTimeout);
    }

    /**
     * 发送消息
     * @param topic 指定topic，不指定使用sendMessage(StringMessage message, long timeoutInMilliSeconds)方法
     * @param message
     * @param timeoutInMilliSeconds
     * @return
     * @throws MQException
     */
    public SendResult sendMessage(String topic, StringMessage message, long timeoutInMilliSeconds) throws MQException{
        //验证入参
        Assert.notNull(topic);
        Assert.notNull(message);
        Assert.notNull(message.getBody());
        Assert.isTrue(timeoutInMilliSeconds > 0, "超时时间必须大于0");

        //消息发送
        try {
            return producer.send(new Message(topic,
                    message.getTags(),
                    message.getKeys(),
                    message.getBody().getBytes("UTF-8")),
                    timeoutInMilliSeconds);
        } catch (Exception e) {
            throw  new MQException(e);
        }
    }

    public void afterPropertiesSet() throws Exception {
        //配置验证
        Assert.hasText(application,"application为空");
        Assert.hasText(nameServerAddress, "NameServer Address为空");

        //创建对象
        producer = new DefaultMQProducer(this.application);
        producer.setNamesrvAddr(nameServerAddress);
        producer.setVipChannelEnabled(false);
        //启动
        producer.start();
    }

    public void destroy() throws Exception {
        try {
            producer.shutdown();
        } finally {
            LOGGER.warn("SimpleProducer called shutdown.");
        }
    }

}
