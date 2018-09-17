package com.tebon.ams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @description: ${description}
 * @author: dfz
 * @create: 2018-09-17
 **/

@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(value = {"com.tebon.ams.*"})
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@EnableTransactionManagement(proxyTargetClass = true)
public class BaseApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class);
    }

    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(BaseApplication.class);
    }
}