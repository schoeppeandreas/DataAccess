package de.ans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import de.ans.primary_ds.Access_tbl_HP_Daten;
import de.ans.secondary_ds.ImportLog;

@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class })
// @SpringBootApplication (exclude = { DataSourceAutoConfiguration.class,
// HibernateJpaAutoConfiguration.class,
// DataSourceTransactionManagerAutoConfiguration.class })
@Configuration
public class DataAccessApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(DataAccessApplication.class, args);
	}

	// @Bean
	// @Primary
	// @ConfigurationProperties(prefix = "datasource.primary")
	// public DataSource numberMasterDataSource() {
	// return DataSourceBuilder.create().build();
	// }
	//
	// @Bean("dsPrTx")
	// public DataSourceTransactionManager dsPrTx() {
	// return new DataSourceTransactionManager(numberMasterDataSource());
	// }
	//
	//
	// @Bean
	// @ConfigurationProperties(prefix = "datasource.secondary")
	// public DataSource provisioningDataSource() {
	// return DataSourceBuilder.create().build();
	// }
	//
	// @Bean("dsSeTx")
	// public DataSourceTransactionManager dsSeTx() {
	// return new DataSourceTransactionManager(provisioningDataSource());
	// }

	@Autowired
	DataService ds;

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		List<ImportLog> lil = ds.getImportLog();
		List<Access_tbl_HP_Daten> lhp = ds.getAccess_tbl_HP_Daten("X7H41EA");

		System.out.println(lil.size() + " <> Import Log");
		System.out.println(lhp.size() + " <> HP Daten");

	}

	// http://stackoverflow.com/questions/27614301/spring-boot-multiple-datasource
	// https://github.com/schoeppeandreas/demo-multi-entity-managers

}
