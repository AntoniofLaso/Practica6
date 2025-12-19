package ZA.LungScanAI.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DiagnosisReportTest {

    @Test
    @DisplayName("Should test full constructor and getters")
    void testConstructorAndGetters() {
        // 1. Arrange & Act
        LocalDate date = LocalDate.now();
        DiagnosisReport report = new DiagnosisReport("Alice", "Pneumonia", 88.5, date);
        report.setId(10L);

        // 2. Assert
        assertEquals(10L, report.getId());
        assertEquals("Alice", report.getPatientName());
        assertEquals("Pneumonia", report.getDiseaseDetected());
        assertEquals(88.5, report.getProbability());
        assertEquals(date, report.getReportDate());
    }

    @Test
    @DisplayName("Should test empty constructor and setters")
    void testSetters() {
        // 1. Arrange
        DiagnosisReport report = new DiagnosisReport();
        LocalDate date = LocalDate.of(2023, 12, 1);

        // 2. Act
        report.setId(5L);
        report.setPatientName("Bob");
        report.setDiseaseDetected("Healthy");
        report.setProbability(10.0);
        report.setReportDate(date);

        // 3. Assert
        assertEquals(5L, report.getId());
        assertEquals("Bob", report.getPatientName());
        assertEquals("Healthy", report.getDiseaseDetected());
        assertEquals(10.0, report.getProbability());
        assertEquals(date, report.getReportDate());
    }
}