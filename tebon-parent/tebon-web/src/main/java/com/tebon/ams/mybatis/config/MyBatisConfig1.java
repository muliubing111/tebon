package com.tebon.ams.mybatis.config;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import com.tebon.ams.mybatis.param.DBConfig1;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @description: ${description}
 * @author: dfz
 * @create: 2018-09-15
 **/
@Configuration
@MapperScan(basePackages = "com.tebon.ams.ams", sqlSessionTemplateRef = "amsSqlSessionTemplate")
public class MyBatisConfig1 {
    // 配置数据源
    @Primary
    @Bean(name = "amsDataSource")
    public DataSource testDataSource(DBConfig1 amsConfig) throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(amsConfig.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(amsConfig.getPassword());
        mysqlXaDataSource.setUser(amsConfig.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("amsDataSource");

        xaDataSource.setMinPoolSize(amsConfig.getMinPoolSize());
        xaDataSource.setMaxPoolSize(amsConfig.getMaxPoolSize());
        xaDataSource.setMaxLifetime(amsConfig.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(amsConfig.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(amsConfig.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(amsConfig.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(amsConfig.getMaxIdleTime());
        xaDataSource.setTestQuery(amsConfig.getTestQuery());
        return xaDataSource;
    }

    @Primary
    @Bean(name = "amsSqlSessionFactory")
    public SqlSessionFactory amsSqlSessionFactory(@Qualifier("amsDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.tebon.ams.model.entity");
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:spring/mybatis/**/*.xml"));
        return bean.getObject();
    }

    @Primary
    @Bean(name = "amsSqlSessionTemplate")
    public SqlSessionTemplate amsSqlSessionTemplate(
            @Qualifier("amsSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
