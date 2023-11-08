package ru.gurov.api.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gurov.api.Models.Equipments;
import ru.gurov.api.Models.Responsible_persons;
import ru.gurov.api.Repositories.EquipmentRepository;
import ru.gurov.api.Repositories.ResponsibleRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class ResponsibleController {
    private final ResponsibleRepository responsibleRepository;

    @GetMapping("/responsible")
    public ResponseEntity<Object> getAllResponsible(){
        try {
            Iterable<Responsible_persons> responsible = responsibleRepository.findAll();
            return new ResponseEntity<>(responsible, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/responsible/{fio}")
    public ResponseEntity<Object> getResponsibleById(@PathVariable("fio") String fio) {
        try {
            Responsible_persons responsible = responsibleRepository.findByFull(fio).orElseThrow();
            return new ResponseEntity<>(responsible, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/responsible")
    public ResponseEntity<Object> createResponsible(@RequestBody Responsible_persons responsible) {
        try {
            Responsible_persons savedResponsible = responsibleRepository.save(responsible);
            return new ResponseEntity<>(savedResponsible, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/responsible/{id}")
    public ResponseEntity<Object> updateResponsible(@PathVariable("id") Long id, @RequestBody Responsible_persons responsible) {
        try {
            responsible.setId(id);
            Responsible_persons savedResponsible = responsibleRepository.save(responsible);
            return new ResponseEntity<>(savedResponsible, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/responsible/{id}")
    public ResponseEntity<HttpStatus> deleteResponsible(@PathVariable("id") Long id) {
        try {
            responsibleRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
