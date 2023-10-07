package ru.gurov.api.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.Models.Responsible;
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
            Iterable<Responsible> responsible = responsibleRepository.findAll();
            return new ResponseEntity<Object>(responsible, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/responsible/{id}")
    public ResponseEntity<Object> getResponsibleById(@PathVariable("id") Long id) {
        try {
            Responsible responsible = responsibleRepository.findById(id).get();
            if(responsible != null) {
                return new ResponseEntity<Object>(responsible, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/responsible/create")
    public ResponseEntity<Object> createResponsible(@RequestBody Responsible responsible) {
        try {
            Responsible savedResponsible = responsibleRepository.save(responsible);
            return new ResponseEntity<Object>(savedResponsible, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/responsible/{id}")
    public ResponseEntity<Object> updateResponsible(@PathVariable("id") Long id, @RequestBody Responsible responsible) {
        try {
            responsible.setId(id);
            Responsible savedResponsible = responsibleRepository.save(responsible);
            return new ResponseEntity<Object>(savedResponsible, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/responsible/{id}")
    public ResponseEntity<HttpStatus> deleteResponsible(@PathVariable("id") Long id) {
        try {
            responsibleRepository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
