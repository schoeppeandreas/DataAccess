package de.ans.primary_ds;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional //("primaryTransactionManager")
public interface Access_tbl_HP_Daten_Repository extends JpaRepository<Access_tbl_HP_Daten, Integer> {
	List<Access_tbl_HP_Daten> findByProductNumber(String productNumber);
}
