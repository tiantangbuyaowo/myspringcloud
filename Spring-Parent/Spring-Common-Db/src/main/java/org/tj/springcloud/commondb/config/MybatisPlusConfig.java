package org.tj.springcloud.commondb.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {
    /*  *//**
     * mybatis-plus SQL执行效率插件【生产环境可以关闭】
     *//*
    @Bean
    public SqlExplainInterceptor performanceInterceptor() {
        return new SqlExplainInterceptor();
    }
*/

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}

