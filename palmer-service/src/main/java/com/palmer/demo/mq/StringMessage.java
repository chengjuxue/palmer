package com.palmer.demo.mq;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/12/26, at 上午11:04
 * @Modified by:
 * @Description:
 */
@Data
public class StringMessage implements Serializable {
    private static final long serialVersionUID = 4527867356503105040L;

    private String body;
    private String keys;
    private String tags;

    public StringMessage(String body){
        this.body = body;
    }

    public StringMessage(String body, String keys){
        this.body = body;
        this.keys = keys;
    }

    public StringMessage(String body, String keys, String tags){
        this.body = body;
        this.keys = keys;
        this.tags = tags;
    }
}
