package ZA.LungScanAI.services;
import ZA.LungScanAI.model.DiagnosisReport;
import ZA.LungScanAI.repository.DiagnosisRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DiagnosisServiceTest {

    @Mock
    private DiagnosisRepository diagnosisRepository;

    @InjectMocks
    private DiagnosisService diagnosisService;

    @Test
    @DisplayName("Should save a diagnosis report successfully")
    void testSave() {
      
        DiagnosisReport report = new DiagnosisReport("John Doe", "Covid-19", 95.5, LocalDate.now());
        when(diagnosisRepository.save(any(DiagnosisReport.class))).thenReturn(report);


        DiagnosisReport saved = diagnosisService.save(report); 


        assertNotNull(saved);
        assertEquals("John Doe", saved.getPatientName());
        verify(diagnosisRepository, times(1)).save(report);
    }

    @Test
    @DisplayName("Should return a list of all diagnosis")
    void testFindAll() {
        // 1. Arrange
        when(diagnosisRepository.findAll()).thenReturn(Arrays.asList(new DiagnosisReport(), new DiagnosisReport()));

        // 2. Act
        List<DiagnosisReport> list = diagnosisService.findAll();

        // 3. Assert
        assertEquals(2, list.size());
        verify(diagnosisRepository, times(1)).findAll();
    }
    
    @Test
    @DisplayName("Should find diagnosis by ID")
    void testFindById() {
        // 1. Arrange
        Long id = 1L;
        DiagnosisReport report = new DiagnosisReport();
        report.setId(id);
        when(diagnosisRepository.findById(id)).thenReturn(Optional.of(report));

        // 2. Act
        DiagnosisReport found = diagnosisService.findById(id);

        // 3. Assert
        assertNotNull(found);
        assertEquals(id, found.getId());
    }
}