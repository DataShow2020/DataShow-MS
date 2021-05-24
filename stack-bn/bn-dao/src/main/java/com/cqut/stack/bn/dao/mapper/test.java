package com.cqut.stack.bn.dao.mapper;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/cqut/stack/bn/dao/mapping/ShowMapper.xml");
    }
}
