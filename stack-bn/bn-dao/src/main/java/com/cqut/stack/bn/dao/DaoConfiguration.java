package com.cqut.stack.bn.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:com/cqut/stack/bn/dao/mybatis-config.properties")
@MapperScan("com.cqut.stack.bn.dao.mapper")
public class DaoConfiguration {

}
