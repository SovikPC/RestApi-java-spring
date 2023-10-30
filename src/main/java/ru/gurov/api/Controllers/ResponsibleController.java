package ru.gurov.api.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.Models.Responsible_persons;
import ru.gurov.api.Repositoryes.ResponsibleRepository;


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
            Responsible_persons responsiblePersons = responsibleRepository.findByFio(fio).orElseThrow();
            if(responsiblePersons != null) {
                return new ResponseEntity<>(responsiblePersons, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/responsible")
    public ResponseEntity<Object> createResponsible(@RequestBody Responsible_persons responsiblePersons) {
        try {
            Responsible_persons savedResponsiblePersons = responsibleRepository.save(responsiblePersons);
            return new ResponseEntity<>(savedResponsiblePersons, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/responsible/{id}")
    public ResponseEntity<Object> updateResponsible(@PathVariable("id") Long id, @RequestBody Responsible_persons responsiblePersons) {
        try {
            responsiblePersons.setId_responsible(id);
            Responsible_persons savedResponsiblePersons = responsibleRepository.save(responsiblePersons);
            return new ResponseEntity<>(savedResponsiblePersons, HttpStatus.OK);
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
