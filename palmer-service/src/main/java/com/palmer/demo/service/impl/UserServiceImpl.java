package com.palmer.demo.service.impl;

import com.palmer.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/7/26, at 下午9:11
 * @Modified by:
 * @Description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    public String getUserNameById(Integer id) {
        if(id.equals(1)){
            return "张三";
        }else {
            return "李四";
        }
    }

    public boolean isGreaterThanAge(Integer age) {
        if(age.compareTo(50)>=0) {
            return true;
        }else {
            return false;
        }
    }

}
