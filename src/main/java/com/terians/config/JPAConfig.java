package com.terians.config;

import com.terians.properties.JPADatabaseProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by stromero on 10/8/2014.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages={"com.terians.jpa.repository"})
public class JPAConfig {

    @Autowired
    private JPADatabaseProperties config;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource(config));
        em.setPackagesToScan(new String[] {"com.terians.jpa.model"});

        HibernateJpaVendorAdapter  vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(Boolean.TRUE);
        vendorAdapter.setShowSql(Boolean.TRUE);

        em.setJpaVendorAdapter(vendorAdapter);

        // JPA Properties

        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        properties.setProperty("hibernate.show_sql", "true");
        em.setJpaProperties(properties);

        return em;
    }

    @Bean
    public DataSource dataSource(JPADatabaseProperties config){
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName(config.getDriverClass());
        datasource.setUrl(config.getConnectionURL());
        datasource.setUsername(config.getUserID());
        datasource.setPassword(config.getPassword());

        return datasource;
    }


    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
