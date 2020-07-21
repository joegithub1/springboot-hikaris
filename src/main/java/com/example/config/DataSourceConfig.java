package com.example.config;/**
 * @title: DataSourceConfig
 * @projectName springboot-hikaris
 * @description:
 * @author HuangJian
 * @date 2020-07-21
 */

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


/**
 *@description: 数据源配置中心
 *@author: huangJian
 *@create: 2020-07-21
 */
@Configuration
public class DataSourceConfig {
    private final static Logger LOGGER = LoggerFactory.getLogger(DataSourceConfig.class);


    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource masterDataSource(DataSourceProperties properties) {
        System.out.println(properties);
        return DataSourceBuilder.create().build();

    }


    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slaveDataSource(DataSourceProperties properties) {
        System.out.println(properties);
        return DataSourceBuilder.create().build();

    }


}
