package scr.main.java.homework.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author liwang
 * @date 2020/3/4 4:43 下午
 * @description
 **/

@Configuration
@MapperScan(basePackages = "homework.dao", sqlSessionTemplateRef = "activeSqlSessionTemplate")
public class ActiveSourceConfig {

    /**
     * 创建数据源
     *
     * @return DataSource
     */
    @Bean(name = "activeDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.active")
    public DataSource masterDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 创建工厂
     *
     * @param dataSource
     * @return SqlSessionFactory
     * @throws Exception
     */
    @Bean(name = "activeSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("activeDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/active/**/*.xml"));
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session
                .Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        return bean.getObject();
    }

    /**
     * 创建事务
     *
     * @param dataSource
     * @return DataSourceTransactionManager
     */
    @Bean(name = "activeTransactionManager")
    public DataSourceTransactionManager masterDataSourceTransactionManager(@Qualifier("activeDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 创建模板
     *
     * @param sqlSessionFactory
     * @return SqlSessionTemplate
     */
    @Bean(name = "activeSqlSessionTemplate")
    public SqlSessionTemplate masterSqlSessionTemplate(@Qualifier("activeSqlSessionFactory") SqlSessionFactory
                                                               sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
