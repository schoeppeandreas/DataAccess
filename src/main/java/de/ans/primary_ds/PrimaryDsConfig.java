package de.ans.primary_ds;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource({ "classpath:primary_ds.properties" }) ///src/main/resources/
@EnableJpaRepositories(
    basePackages = "de.ans.primary_ds", 
    entityManagerFactoryRef = "primaryEntityManager", 
    transactionManagerRef = "primaryTransactionManager"
)
public class PrimaryDsConfig {
    @Autowired
    private Environment env;
     
    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean primaryEntityManager() {
        LocalContainerEntityManagerFactoryBean em
          = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(primaryDataSource());
        em.setPackagesToScan(
          new String[] { "de.ans.primary_ds" });
 
        HibernateJpaVendorAdapter vendorAdapter
          = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
          env.getProperty("primary.hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect",
          env.getProperty("primary.hibernate.dialect"));
        em.setJpaPropertyMap(properties);
 
        return em;
    }
 
    @Primary
    @Bean
    public DataSource primaryDataSource() {
  
        DriverManagerDataSource dataSource
          = new DriverManagerDataSource();
        dataSource.setDriverClassName(
          env.getProperty("primary.jdbc.driverClassName"));
        
        System.out.println(env.getProperty("primary.jdbc.url") + " << Primary DS" );
        System.out.println(env.getProperty("primary.jdbc.user") + " << Primary DS" );
        System.out.println(env.getProperty("primary.jdbc.pass") + " << Primary DS" );
        
        dataSource.setUrl(env.getProperty("primary.jdbc.url"));
        dataSource.setUsername(env.getProperty("primary.jdbc.user"));
        dataSource.setPassword(env.getProperty("primary.jdbc.pass"));
 
        return dataSource;
    }
 
    @Primary
    @Bean
    public PlatformTransactionManager primaryTransactionManager() {
        JpaTransactionManager transactionManager
          = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
          primaryEntityManager().getObject());
        return transactionManager;
    }
}