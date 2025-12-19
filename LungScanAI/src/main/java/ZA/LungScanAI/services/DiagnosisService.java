package ZA.LungScanAI.services;

import ZA.LungScanAI.model.DiagnosisReport;
import ZA.LungScanAI.repository.DiagnosisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisService {

    private final DiagnosisRepository repository;


    public DiagnosisService(DiagnosisRepository repository) {
        this.repository = repository;
    }


    public List<DiagnosisReport> findAll() {
        return repository.findAll();
    }

    public DiagnosisReport findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public DiagnosisReport save(DiagnosisReport report) {
        return repository.save(report);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
