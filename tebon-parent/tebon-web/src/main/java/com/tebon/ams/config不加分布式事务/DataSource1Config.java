package com.tebon.ams.config不加分布式事务;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @description: 多数据源不加事务的配置
 * @author: dfz
 * @create: 2018-09-15
 **/
//@Configuration // 注册到springboot容器中
@MapperScan(basePackages = "com.tebon.ams.ams", sqlSessionFactoryRef = "amsSqlSessionFactory")
public class DataSource1Config {
    /**
     *
     * @methodDesc: 功能描述:(配置ams数据库)
     * @param: @return
     * @createTime:2017年9月17日 下午3:16:44
     * @returnType:@return DataSource
     */
    @Bean(name = "amsDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.ams")
    @Primary
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     *
     * @methodDesc: 功能描述:(ams sql会话工厂)
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
    @Bean(name = "amsSqlSessionFactory")
    @Primary
    public SqlSessionFactory amsSqlSessionFactory(@Qualifier("amsDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // bean.setMapperLocations(
        // new
        // PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/ams/*.xml"));
        return bean.getObject();
    }

    /**
     *
     * @methodDesc: 功能描述:(ams 事物管理)
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
    @Bean(name = "amsTransactionManager")
    @Primary
    public DataSourceTransactionManager amsTransactionManager(@Qualifier("amsDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "amsSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate amsSqlSessionTemplate(
            @Qualifier("amsSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
