package com.tebon.ams.mybatis.param;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 多数据源通过jta+atomics解决分布式事务
 * 配置有2种方式：(1)ConfigurationProperties,这样的话最好每个数据源一个dataParamConfig，同时在Application.class中扫包EnableConfigurationProperties(value = { DBConfig1.class, DBConfig2.class })
 * (2)用Value注解，这样可以在一个类写
 * 如果参数太多建议第一种方式ConfigurationProperties(prefix,locations="classpath:config/auth.properties") 本例中不需要locations
 * @author: dfz
 * @create: 2018-09-15
 **/
@Data
@ConfigurationProperties(prefix = "mysql.datasource.ams")
@Configuration
public class DBConfig1 {

    private String url;
    private String username;
    private String password;
    private int minPoolSize;
    private int maxPoolSize;
    private int maxLifetime;
    private int borrowConnectionTimeout;
    private int loginTimeout;
    private int maintenanceInterval;
    private int maxIdleTime;
    private String testQuery;

}
