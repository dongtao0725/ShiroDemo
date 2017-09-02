package com.dongt.shiroDemo.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.sql.SQLException;


/**
 * ComponentScan的属性
 basePackageClasses：对basepackages()指定扫描注释组件包类型安全的替代。
 excludeFilters：指定不适合组件扫描的类型。
 includeFilters：指定哪些类型有资格用于组件扫描。
 lazyInit：指定是否应注册扫描的beans为lazy初始化。
 nameGenerator：用于在Spring容器中的检测到的组件命名。
 resourcePattern：控制可用于组件检测的类文件。
 scopedProxy：指出代理是否应该对检测元件产生，在使用过程中会在代理风格时尚的范围是必要的。
 scopeResolver：用于解决检测到的组件的范围。
 useDefaultFilters：指示是否自动检测类的注释 @Component@Repository, @Service, or @Controller 应启用。
 value：basePackages()别名
 */
@Configuration
@ComponentScan(basePackages = {"com.dongt.shiroDemo"},
        excludeFilters = {
        @ComponentScan.Filter(  type = FilterType.ANNOTATION,value = EnableWebMvc.class )
})
@MapperScan(basePackages="com.dongt.shiroDemo.dao")
@EnableTransactionManagement
@Import({ShiroConfig.class})
public class RootConfig {

    @Bean
    public DriverManagerDataSource dataSource() throws Exception {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        /*  基本属性 */
        ds.setDriverClassName("com.hxtt.sql.access.AccessDriver");
        ds.setUrl("jdbc:Access:///D:/IdeaProjects/ShiroDemo/src/main/webapp/data/#%Shiro.mdb");
        return ds;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setMapperLocations( new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.dongt.shiroDemo.domain");
        return  sqlSessionFactoryBean;
    }

    @Bean
    public DataSourceTransactionManager txManager() throws Exception{
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }
}
