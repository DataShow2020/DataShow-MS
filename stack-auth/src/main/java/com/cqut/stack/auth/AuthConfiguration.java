package com.cqut.stack.auth;

import com.cqut.stack.bn.dao.DaoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:com/cqut/stack/bn/dao/mybatis-config.properties")
@Import(DaoConfiguration.class)
public class AuthConfiguration {
}
