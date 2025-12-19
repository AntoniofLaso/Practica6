package ZA.LungScanAI;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class DiagnosisReportTest {

    @Test
    @DisplayName("Should create entity correctly and retrieve values")
    void testEntityGettersAndSetters() {
        // --- 1. ARRANGE (Preparar) ---
        Long id = 1L;
        String name = "Test Patient";
        String diagnosis = "Healthy";
        LocalDateTime now = LocalDateTime.now();

        // --- 2. ACT (Actuar) ---
        DiagnosisReport report = new DiagnosisReport();
        report.setId(id);
        report.setPatientName(name);
        report.setDiagnosisResult(diagnosis);
        report.setDate(now);

        // --- 3. ASSERT (Verificar) ---
        assertAll("Entity properties",
            () -> assertEquals(id, report.getId()),
            () -> assertEquals(name, report.getPatientName()),
            () -> assertEquals(diagnosis, report.getDiagnosisResult()),
            () -> assertEquals(now, report.getDate())
        );
    }
}
