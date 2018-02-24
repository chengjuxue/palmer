package com.palmer.demo.test;

import com.palmer.demo.util.ByteConvert;
import org.junit.Test;

import java.security.SecureRandom;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/7/28, at 下午1:58
 * @Modified by:
 * @Description:
 */
public class CommonTest extends BaseTest{

    static {
        i = 3;
    }

    public static int i;

    @Test
    public void testRandom(){
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        String s = ByteConvert.bytesToHexString(bytes);
        System.out.println(s);
    }

    public static void main(String[] args) {
        Integer num = 0;
        System.out.println(num == 1);

        System.out.println(String.class.getName());

        System.out.println("=================");
        System.out.println(5/2);

        System.out.println(i);
    }

}
