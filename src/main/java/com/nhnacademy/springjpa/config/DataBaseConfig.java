package com.nhnacademy.springjpa.config;

import com.nhnacademy.springjpa.properties.DataBaseProperties;
import lombok.RequiredArgsConstructor;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@RequiredArgsConstructor
@Configuration
public class DataBaseConfig {

    private final DataBaseProperties dataBaseProperties;

    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(dataBaseProperties.getDriverClassName());
        dataSource.setUrl(dataBaseProperties.getUrl());
        dataSource.setUsername(dataBaseProperties.getUsername());
        dataSource.setPassword(dataBaseProperties.getPassword());
        dataSource.setInitialSize(dataBaseProperties.getInitialSize());
        dataSource.setMaxTotal(dataBaseProperties.getMaxTotal());
        dataSource.setMinIdle(dataBaseProperties.getMinIdle());
        dataSource.setMaxIdle(dataBaseProperties.getMaxIdle());
        dataSource.setTestOnBorrow(dataBaseProperties.isTestOnBorrow());
        if(dataBaseProperties.isTestOnBorrow()){
            dataSource.setValidationQuery(dataSource.getValidationQuery());
        }
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }
}
