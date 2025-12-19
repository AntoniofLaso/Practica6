package ZA.LungScanAI;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DiagnosisServiceTest {

    @Mock
    private DiagnosisRepository diagnosisRepository; // Mock del Repo

    @InjectMocks
    private DiagnosisService diagnosisService; // Servicio a probar

    @Test
    @DisplayName("Should save a diagnosis report successfully")
    void testSaveDiagnosis() {
        // 1. Arrange
        DiagnosisReport report = new DiagnosisReport();
        report.setPatientName("John Doe");
        
        when(diagnosisRepository.save(any(DiagnosisReport.class))).thenReturn(report);

        // 2. Act
        // CAMBIA 'saveDiagnosis' por el nombre real de tu método en el Servicio
        DiagnosisReport saved = diagnosisService.saveDiagnosis(report); 

        // 3. Assert
        assertNotNull(saved);
        assertEquals("John Doe", saved.getPatientName());
        verify(diagnosisRepository, times(1)).save(report);
    }

    @Test
    @DisplayName("Should return a list of diagnosis")
    void testGetAllDiagnosis() {
        // 1. Arrange
        when(diagnosisRepository.findAll()).thenReturn(Arrays.asList(new DiagnosisReport(), new DiagnosisReport()));

        // 2. Act
        // CAMBIA 'getAllDiagnosis' por el nombre real de tu método en el Servicio
        List<DiagnosisReport> list = diagnosisService.getAllDiagnosis();

        // 3. Assert
        assertEquals(2, list.size());
        verify(diagnosisRepository, times(1)).findAll();
    }
    
    // Si tienes un método getById en tu servicio, añade el test aquí para llegar al 100%
}
