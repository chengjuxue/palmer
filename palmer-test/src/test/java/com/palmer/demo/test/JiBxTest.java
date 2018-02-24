package com.palmer.demo.test;

import com.palmer.demo.service.netty.jibx.Address;
import com.palmer.demo.service.netty.jibx.Order;
import org.jibx.runtime.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/9/6, at 下午8:55
 * @Modified by:
 * @Description:
 */
public class JiBxTest extends BaseTest {
    private IBindingFactory factory = null;

    private StringWriter writer = null;
    private StringReader reader = null;

    private Order bean = null;
    @Before
    public void init() {
        bean = new Order();
        bean.setNum((long)100);
        Address address = new Address();
        address.setCountry("China");
        address.setCity("杭州");
        address.setStreet("解放东路");
        bean.setAddress(address);
        try {
            factory = BindingDirectory.getFactory(Order.class);
        } catch (JiBXException e) {
            e.printStackTrace();
        }
    }

    @After
    public void destory() {
        bean = null;
        try {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void bean2XML() {
        try {
            writer = new StringWriter();
            // marshal 编组
            IMarshallingContext mctx = factory.createMarshallingContext();
            mctx.setIndent(2);
            mctx.marshalDocument(bean, "UTF-8", null, writer);
            fail(writer);

            reader = new StringReader(writer.toString());
            //unmarshal 解组
            IUnmarshallingContext uctx = factory.createUnmarshallingContext();
            Order order = (Order) uctx.unmarshalDocument(reader, null);
            fail(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void fail(Object o) {
        System.out.println(o);
    }

    public void failRed(Object o) {
        System.err.println(o);
    }
}
