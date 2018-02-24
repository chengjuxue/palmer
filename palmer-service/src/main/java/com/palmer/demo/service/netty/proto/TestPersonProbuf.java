package com.palmer.demo.service.netty.proto;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/8/31, at 上午10:07
 * @Modified by:
 * @Description:{probuf测试}
 */
public class TestPersonProbuf {
    private static PersonProbuf.Person createPerson(){
        PersonProbuf.Person.Builder builder = PersonProbuf.Person.newBuilder();
        builder.setName("小哈哈");
        builder.setId(1);
        builder.setEmail("gugu@gmail.com");
        builder.addPhone(
                PersonProbuf.Person.PhoneNumber.newBuilder()
                    .setNumber("18866669999")
                    .setType(PersonProbuf.Person.PhoneType.HOME));
        builder.addPhone(
                PersonProbuf.Person.PhoneNumber.newBuilder()
                        .setNumber("16688889999")
                        .setType(PersonProbuf.Person.PhoneType.MOBILE));
        return builder.build();
    }

    private static byte[] encode(PersonProbuf.Person person){
        return person.toByteArray();
    }

    private static PersonProbuf.Person decode(byte[] body) throws InvalidProtocolBufferException {
        return PersonProbuf.Person.parseFrom(body);
    }

    public static void main(String[] args) throws InvalidProtocolBufferException{
        PersonProbuf.Person person1 = createPerson();
        System.out.println("person1: " + person1.toString());
        PersonProbuf.Person person2 = decode(encode(person1));
        System.out.println("person2: " + person2.toString());
        System.out.println("person1.equals(person2): " + person1.equals(person2));
    }
}
