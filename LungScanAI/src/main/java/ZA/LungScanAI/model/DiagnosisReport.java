package ZA.LungScanAI.model; // <--- CORREGIDO (Antes decía com.proyecto...)

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "diagnosis_reports") // Recomendado: Asignar nombre a la tabla
public class DiagnosisReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private String diseaseDetected;
    private double probability;
    private LocalDate reportDate;

    // Constructor vacío (Obligatorio para JPA)
    public DiagnosisReport() {}

    // Constructor con campos (Útil para los tests)
    public DiagnosisReport(String patientName, String diseaseDetected, double probability, LocalDate reportDate) {
        this.patientName = patientName;
        this.diseaseDetected = diseaseDetected;
        this.probability = probability;
        this.reportDate = reportDate;
    }

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