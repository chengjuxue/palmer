package com.palmer.demo.facade.api;

import org.springframework.stereotype.Service;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/11/17, at 上午11:32
 * @Modified by:
 * @Description:
 */
@Service("sayHelloService")
public class SayHelloServiceImpl implements SayHelloService{
    public String sayHello(String name) {
        return "hello, " + name +"!";
    }
}
