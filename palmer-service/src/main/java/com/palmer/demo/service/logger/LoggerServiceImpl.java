package com.palmer.demo.service.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/7/26, at 下午2:54
 * @Modified by:
 * @Description:
 */
@Service("loggerService")
public class LoggerServiceImpl implements LoggerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerServiceImpl.class);

    public static void main(String[] args) {
        LOGGER.error("这是错误日志。。。");
        LOGGER.warn("这是警告日志。。。");
        LOGGER.info("这是信息日志。。。");
        LOGGER.debug("这是调试日志。。。");
    }
}
