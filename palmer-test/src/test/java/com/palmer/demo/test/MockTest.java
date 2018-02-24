package com.palmer.demo.test;

import com.palmer.demo.model.User;
import com.palmer.demo.service.UserService;
import com.palmer.demo.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/7/26, at 下午9:05
 * @Modified by:
 * @Description:
 */
public class MockTest extends BaseTest {
    //对接口进行模拟
    UserService userServiceMock = mock(UserService.class);

    //对类进行模拟
    UserServiceImpl userServiceImplMock = mock(UserServiceImpl.class);

    //基于注解对类进行模拟
    @Mock
    User userMock;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMock(){
        //stub test
        when(userServiceMock.getUserNameById(1)).thenReturn("张三");
        doReturn(true).when(userServiceImplMock).isGreaterThanAge(60);
        when(userMock.getId()).thenReturn(3);

        String name = userServiceMock.getUserNameById(1);
        boolean flag = userServiceImplMock.isGreaterThanAge(60);
        Integer id = userMock.getId();

        assertEquals(name, "张三");
        assertEquals(flag, true);
        assertNotNull(id);

        //verify
        verify(userServiceMock, atLeastOnce()).getUserNameById(2);
        verify(userServiceImplMock, atLeast(1)).isGreaterThanAge(60);
        verify(userMock).getId();

    }

}
