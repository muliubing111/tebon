package com.tebon.ams.config不加分布式事务;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @description: 多数据源不加事务的配置
 * @author: dfz
 * @create: 2018-09-15
 **/
//@Configuration // 注册到springboot容器中
@MapperScan(basePackages = "com.tebon.ams.ams1", sqlSessionFactoryRef = "ams1SqlSessionFactory")
public class DataSource2Config {
    /**
     *
     * @methodDesc: 功能描述:(配置ams1数据库)
     * @param: @return
     * @createTime:2017年9月17日 下午3:16:44
     * @returnType:@return DataSource
     */
    @Bean(name = "ams1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.ams1")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     *
     * @methodDesc: 功能描述:(ams1 sql会话工厂)
     * @param: @param
     *             dataSource
     * @param: @return
     * @param: @throws
     *             Exception
     * @createTime:2017年9月17日 下午3:17:08
     * @returnType:@param dataSource
     * @returnType:@return
     * @returnType:@throws Exception SqlSessionFactory
     */
    @Bean(name = "ams1SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("ams1DataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // bean.setMapperLocations(
        // new
        // PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/ams1/*.xml"));
        return bean.getObject();
    }

    /**
     *
     * @methodDesc: 功能描述:(ams1 事物管理)
     * @param: @param
     *             dataSource
     * @param: @return
     * @param: @throws
     *             Exception
     * @createTime:2017年9月17日 下午3:17:08
     * @returnType:@param dataSource
     * @returnType:@return
     * @returnType:@throws Exception SqlSessionFactory
     */
    @Bean(name = "ams1TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("ams1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "ams1SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("ams1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

