package com.palmer.demo.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/7/26, at 下午2:31
 * @Modified by:
 * @Description:
 */
public class LogTest extends BaseTest{

    @Test
    public void testLog(){
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        logger.error("测试：错误日志");
        logger.warn("测试：警告日志");
        logger.info("测试：信息日志");
        logger.debug("测试：调试日志");
    }
}
