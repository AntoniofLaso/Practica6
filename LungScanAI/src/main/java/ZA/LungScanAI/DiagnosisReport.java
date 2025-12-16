package com.proyecto.LungScanAI.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DiagnosisReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private String diseaseDetected;
    private double probability;
    private LocalDate reportDate;

    // Getters y setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getPatientName() { return patientName; }

    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getDiseaseDetected() { return diseaseDetected; }

    public void setDiseaseDetected(String diseaseDetected) { this.diseaseDetected = diseaseDetected; }

    public double getProbability() { return probability; }

    public void setProbability(double probability) { this.probability = probability; }

    public LocalDate getReportDate() { return reportDate; }

    public void setReportDate(LocalDate reportDate) { this.reportDate = reportDate; }
}
