package com.tebon.ams.mybatis.config;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import com.tebon.ams.mybatis.param.DBConfig2;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @description: ${description}
 * @author: dfz
 * @create: 2018-09-15
 **/
@Configuration
@MapperScan(basePackages = "com.tebon.ams.ams1", sqlSessionTemplateRef = "ams1SqlSessionTemplate")
public class MybatisConfig2 {

    // 配置数据源
    @Bean(name = "ams1DataSource")
    public DataSource testDataSource(DBConfig2 ams1Config) throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(ams1Config.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(ams1Config.getPassword());
        mysqlXaDataSource.setUser(ams1Config.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("ams1DataSource");

        xaDataSource.setMinPoolSize(ams1Config.getMinPoolSize());
        xaDataSource.setMaxPoolSize(ams1Config.getMaxPoolSize());
        xaDataSource.setMaxLifetime(ams1Config.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(ams1Config.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(ams1Config.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(ams1Config.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(ams1Config.getMaxIdleTime());
        xaDataSource.setTestQuery(ams1Config.getTestQuery());
        return xaDataSource;
    }

    @Bean(name = "ams1SqlSessionFactory")
    public SqlSessionFactory ams1SqlSessionFactory(@Qualifier("ams1DataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.tebon.ams.model.entity");
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:spring/mybatis/**/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "ams1SqlSessionTemplate")
    public SqlSessionTemplate ams1SqlSessionTemplate(
            @Qualifier("ams1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}