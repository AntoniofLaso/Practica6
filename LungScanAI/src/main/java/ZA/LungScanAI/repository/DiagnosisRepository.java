package ZA.LungScanAI.repository;

import ZA.LungScanAI.model.DiagnosisReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepository extends JpaRepository<DiagnosisReport, Long> {
   
}