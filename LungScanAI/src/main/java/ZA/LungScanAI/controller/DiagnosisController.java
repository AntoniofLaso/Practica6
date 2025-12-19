package ZA.LungScanAI.controller;

import ZA.LungScanAI.model.DiagnosisReport;
import ZA.LungScanAI.services.DiagnosisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diagnosis")
public class DiagnosisController {

    private final DiagnosisService service;

    public DiagnosisController(DiagnosisService service) {
        this.service = service;
    }

    @GetMapping
    public List<DiagnosisReport> getAll() {
        return service.findAll();
    }

    @PostMapping
    public DiagnosisReport create(@RequestBody DiagnosisReport report) {
        return service.save(report);
    }

    @PutMapping("/{id}")
    public DiagnosisReport update(@PathVariable Long id, @RequestBody DiagnosisReport report) {
        report.setId(id);
        return service.save(report);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
