package com.proyecto.LungScanAI.repository;

import com.proyecto.LungScanAI.model.DiagnosisReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepository extends JpaRepository<DiagnosisReport, Long> {
}
