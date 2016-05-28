package com.jetminds.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Database config.
 *
 * @author Erik Khalimov.
 */
public class DatabaseConfig {

    /**
     * environment injection.
     */
    @Autowired
    private Environment env;

    /**
     * datasource injection.
     */
    @Autowired
    private DataSource sourceData;

    /**
     * DataSource definition for database connection. Settings are read from
     * the application.properties file (using the env object).
     *
     * @return
     *  returns datasource
     */
    @Bean
    public final DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }

    /**
     * Declare the JPA entity manager factory.
     *
     * @return
     *  returns entity manager factory bean
     */
    @Bean
    public final LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory =
                new LocalContainerEntityManagerFactoryBean();

        entityManagerFactory.setDataSource(sourceData);

        // Classpath scanning of @Component, @Service, etc annotated class
        entityManagerFactory.setPackagesToScan(
                env.getProperty("entitymanager.packagesToScan"));

        // Vendor adapter
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

        // Hibernate properties
        Properties additionalProperties = new Properties();
        additionalProperties.put(
                "hibernate.dialect",
                env.getProperty("hibernate.dialect"));
        additionalProperties.put(
                "hibernate.show_sql",
                env.getProperty("hibernate.show_sql"));
        additionalProperties.put(
                "hibernate.hbm2ddl.auto",
                env.getProperty("hibernate.hbm2ddl.auto"));
        entityManagerFactory.setJpaProperties(additionalProperties);

        return entityManagerFactory;
    }
}
