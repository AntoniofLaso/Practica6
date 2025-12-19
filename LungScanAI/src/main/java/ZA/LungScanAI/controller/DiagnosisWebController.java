package ZA.LungScanAI.controller;

import ZA.LungScanAI.model.DiagnosisReport;
import ZA.LungScanAI.services.DiagnosisService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/diagnosis")
public class DiagnosisWebController {

    private final DiagnosisService service;

    public DiagnosisWebController(DiagnosisService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("reports", service.findAll());
        return "diagnosis-list"; // Busca un archivo HTML llamado así
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("report", new DiagnosisReport());
        return "diagnosis-form"; // Busca un archivo HTML llamado así
    }

    @PostMapping
    public String save(@ModelAttribute DiagnosisReport report) {
        service.save(report);
        return "redirect:/diagnosis";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/diagnosis";
    }
}