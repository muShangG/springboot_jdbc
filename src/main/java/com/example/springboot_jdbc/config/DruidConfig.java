package com.example.springboot_jdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletRegistration;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource(){
        return  new DruidDataSource();
    }

    //配置Druid的监控
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String>stringStringMap=new HashMap<>();
        stringStringMap.put("loginUsername","admin");
        stringStringMap.put("loginPassword","123");
        stringStringMap.put("allow","");
        stringStringMap.put("deny","192.168.1.6");
        bean.setInitParameters(stringStringMap);
        return bean;
    }
    public FilterRegistrationBean webfilter(){
        FilterRegistrationBean bean=new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> stringMap=new HashMap<>();
        bean.setInitParameters(stringMap);
        stringMap.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(stringMap);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
