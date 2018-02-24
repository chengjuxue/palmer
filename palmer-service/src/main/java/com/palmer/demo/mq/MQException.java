package com.palmer.demo.mq;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/12/26, at 上午11:31
 * @Modified by:
 * @Description:
 */
public class MQException extends Exception {
    public MQException(String message, Throwable cause){
        super(message, cause);
    }

    public MQException(Throwable cause){
        super(cause);
    }
}
