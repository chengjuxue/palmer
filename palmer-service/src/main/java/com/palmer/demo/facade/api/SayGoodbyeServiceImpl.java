package com.palmer.demo.facade.api;

import org.springframework.stereotype.Service;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/11/22, at 下午4:30
 * @Modified by:
 * @Description:
 */
@Service("sayGoodbyeService")
public class SayGoodbyeServiceImpl implements SayGoodbyeService{
    public String sayGoodbye(String name) {
        return "bye, " + name +"!";
    }
}
