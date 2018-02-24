package com.palmer.demo.mq;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/12/26, at 下午2:38
 * @Modified by:
 * @Description:
 */
@Component
public class ExampleMessageListener implements MessageListenerConcurrently{
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        //业务逻辑

        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
