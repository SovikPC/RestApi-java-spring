package ru.gurov.api.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gurov.api.Models.Reports;
import ru.gurov.api.Repositories.ReportsRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:2000", allowedHeaders = "*")
public class ReportsController {

    private final ReportsRepository reportsRepository;

    @GetMapping("/reports")
    public ResponseEntity<Object> getAllReports(){
        try {
            Iterable<Reports> reports = reportsRepository.findAll();
            return new ResponseEntity<>(reports, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/reports/{id}")
    public ResponseEntity<Object> getReportsById(@PathVariable("id") Long id) {
        try {
            Reports reports = reportsRepository.findById(id).orElseThrow();
            return new ResponseEntity<>(reports, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/reports")
    public ResponseEntity<Object> createReports(@RequestBody Reports reports) {
        try {
            Reports savedReports = reportsRepository.save(reports);
            return new ResponseEntity<>(savedReports, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/reports/{id}")
    public ResponseEntity<Object> updateReports(@PathVariable("id") Long id, @RequestBody Reports reports) {
        try {
            reports.setId(id);
            Reports savedReport = reportsRepository.save(reports);
            return new ResponseEntity<>(savedReport, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/reports/{id}")
    public ResponseEntity<HttpStatus> deleteEquipment(@PathVariable("id") Long id) {
        try {
            reportsRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
