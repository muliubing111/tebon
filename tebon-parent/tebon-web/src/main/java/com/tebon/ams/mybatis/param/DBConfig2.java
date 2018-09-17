package com.tebon.ams.mybatis.param;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description: jta+atomic配置数据源
 * @author: dfz
 * @create: 2018-09-15
 **/
@Data
@ConfigurationProperties(prefix = "mysql.datasource.ams1")
@Configuration
public class DBConfig2 {
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
