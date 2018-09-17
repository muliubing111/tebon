package com.tebon.ams;


import com.tebon.ams.mybatis.param.DBConfig1;
import com.tebon.ams.mybatis.param.DBConfig2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(value = {"com.tebon.ams.*"})
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@EnableTransactionManagement(proxyTargetClass = true)*/
@SpringBootApplication
public class WebApplication /*extends SpringBootServletInitializer*/{

	/*protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(BaseApplication.class);
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
