package de.ans.secondary_ds;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional //("secondaryTransactionManager")
public interface ImportLogRepository extends JpaRepository<ImportLog, String> {

}
