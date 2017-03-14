package de.ans;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional("dsSeTx")
public interface ImportLogRepository extends JpaRepository<ImportLog, String> {

}
