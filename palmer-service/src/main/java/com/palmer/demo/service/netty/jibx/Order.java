package com.palmer.demo.service.netty.jibx;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/9/6, at 下午8:14
 * @Modified by:
 * @Description:
 */
public class Order {
    private long num;

    private Address address;

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
