package com.palmer.demo.mq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.MessageListener;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerOrderly;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/12/15, at 下午3:56
 * @Modified by:
 * @Description:
 */
@Component
public class SimplePushConsumer implements InitializingBean, DisposableBean{
    private final static Logger LOGGER = LoggerFactory.getLogger(SimplePushConsumer.class);

    @Setter
    private String nameServerAddress;
    @Setter
    private String application;
    @Setter
    private String topic;
    @Setter
    private String tag;

    @Setter
    private MessageListener messageListener;

    private DefaultMQPushConsumer pushConsumer;

    private boolean broadcasting = false;

//    对于Bean实现 InitializingBean，它将运行 afterPropertiesSet()在所有的 bean 属性被设置之后。
    public void afterPropertiesSet() throws Exception {
        //1.验证配置的属性值
        Assert.hasText(nameServerAddress, "NameServer Address为空");
        Assert.hasText(application, "application为空");
        Assert.hasText(topic, "topic为空");
        Assert.notNull(messageListener, "消息监听器为null");

        //2.验证MessageListener类型
        if(!(messageListener instanceof MessageListenerConcurrently) && !(messageListener instanceof MessageListenerOrderly)){
            throw new IllegalArgumentException("messageListener必须是MessageListenerConcurrently或MessageListenerOrderly类型");
        }

        //3.创建DefaultMQPushConsumer实例，指定consumerGroup名
        pushConsumer = new DefaultMQPushConsumer(application.toUpperCase() + "_" + topic);

        //4.设置消费者配置
        pushConsumer.setNamesrvAddr(nameServerAddress);
        //订阅消息，若tag为null,表示订阅指定topic的所有消息
        pushConsumer.subscribe(topic, tag);
        pushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        pushConsumer.setVipChannelEnabled(false);
        //消费模式：集群模式、广播模式
        if(broadcasting){
            pushConsumer.setMessageModel(MessageModel.BROADCASTING);
        }
        if(messageListener instanceof MessageListenerConcurrently){
            pushConsumer.registerMessageListener((MessageListenerConcurrently)messageListener);
        } else {
            pushConsumer.registerMessageListener((MessageListenerOrderly)messageListener);
        }
        //5.启动
        pushConsumer.start();
    }

//    对于 Bean 实现了DisposableBean，它将运行 destroy()在 Spring 容器释放该 bean 之后。
    public void destroy() throws Exception {

    }
}
