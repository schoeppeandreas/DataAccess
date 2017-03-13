package de.ans;

import javax.sql.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@SpringBootApplication
public class DataAccessApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataAccessApplication.class, args);
	}
	
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.primary")
    public DataSource numberMasterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("dsPrTx")
    public DataSourceTransactionManager dsPrTx() {
        return new DataSourceTransactionManager(numberMasterDataSource());
    }
    
    
    @Bean
    @ConfigurationProperties(prefix = "datasource.secondary")
    public DataSource provisioningDataSource() {
        return DataSourceBuilder.create().build();
    }
    
    @Bean("dsSeTx")
    public DataSourceTransactionManager dsSeTx() {
        return new DataSourceTransactionManager(provisioningDataSource());
    }
    
    //http://stackoverflow.com/questions/27614301/spring-boot-multiple-datasource
    
}

