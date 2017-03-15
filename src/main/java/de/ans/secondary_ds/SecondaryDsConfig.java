package de.ans.secondary_ds;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource({ "classpath:secondary_ds.properties" })
@EnableJpaRepositories(
    basePackages = "de.ans.secondary_ds", 
    entityManagerFactoryRef = "secondaryEntityManager", 
    transactionManagerRef = "secondaryTransactionManager"
)
public class SecondaryDsConfig {
    @Autowired
    private Environment env;
     
    @Bean
    public LocalContainerEntityManagerFactoryBean secondaryEntityManager() {
        LocalContainerEntityManagerFactoryBean em
          = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(secondaryDataSource());
        em.setPackagesToScan(
          new String[] { "de.ans.secondary_ds" });
 
        HibernateJpaVendorAdapter vendorAdapter
          = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
          env.getProperty("secondary.hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect",
          env.getProperty("secondary.hibernate.dialect"));
        em.setJpaPropertyMap(properties);
 
        return em;
    }
    
    @Bean
    public DataSource secondaryDataSource() {
  
        DriverManagerDataSource dataSource
          = new DriverManagerDataSource();
        dataSource.setDriverClassName(
          env.getProperty("secondary.jdbc.driverClassName"));
        
        System.out.println(env.getProperty("secondary.jdbc.url") + " << Secondary DS" );
        System.out.println(env.getProperty("secondary.jdbc.user") + " << Secondary DS" );
        System.out.println(env.getProperty("secondary.jdbc.pass") + " << Secondary DS" );
        
        dataSource.setUrl(env.getProperty("secondary.jdbc.url"));
        dataSource.setUsername(env.getProperty("secondary.jdbc.user"));
        dataSource.setPassword(env.getProperty("secondary.jdbc.pass"));
 
        return dataSource;
    }
    
    @Bean
    public PlatformTransactionManager secondaryTransactionManager() {
        JpaTransactionManager transactionManager
          = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
        		secondaryEntityManager().getObject());
        return transactionManager;
    }
}