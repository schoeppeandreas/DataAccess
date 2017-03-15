package de.ans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.ans.primary_ds.Access_tbl_HP_Daten;
import de.ans.primary_ds.Access_tbl_HP_Daten_Repository;
import de.ans.secondary_ds.ImportLog;
import de.ans.secondary_ds.ImportLogRepository;

@Service
public class DataService {

//	private final DataSource primaryDataSource;
//	private final DataSource secondaryDataSource;
//
//	@Autowired
//	public DataSourceService(final DataSource primaryDataSource,
//			@Qualifier("secondaryDataSource") final DataSource secondaryDataSource) {
//		this.primaryDataSource = primaryDataSource;
//		this.secondaryDataSource = secondaryDataSource;
//	}	
	
	@Autowired 
	private Access_tbl_HP_Daten_Repository access_tbl_HP_Daten_Repository;
	
	@Autowired
	private ImportLogRepository importLogRepository;
	
	public List<Access_tbl_HP_Daten> getAccess_tbl_HP_Daten(String productNumber){
		return access_tbl_HP_Daten_Repository.findByProductNumber(productNumber);
	}
	
	public List<ImportLog> getImportLog(){
		return importLogRepository.findAll();
	}
	
}