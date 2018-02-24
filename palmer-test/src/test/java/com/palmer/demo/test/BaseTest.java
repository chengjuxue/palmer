package com.palmer.demo.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/7/26, at 下午1:54
 * @Modified by:
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/test-spring-context.xml"})
public class BaseTest {
}
