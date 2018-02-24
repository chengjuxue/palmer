package com.palmer.demo.service;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/7/26, at 下午9:09
 * @Modified by:
 * @Description:
 */
public interface UserService {
    String getUserNameById(Integer id);

    boolean isGreaterThanAge(Integer age);
}
