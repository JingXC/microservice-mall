package com.atguigu.gulimall.product.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
public class MybatisConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor interceptor = new PaginationInterceptor();
        //设置请求的页面大于最大页后操作，true调回到首页
        interceptor.setOverflow(true);
        //设置最大单页限制数量，-1不受限制
        interceptor.setLimit(500);
        return interceptor;
    }

}
