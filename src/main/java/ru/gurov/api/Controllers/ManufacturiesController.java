package ru.gurov.api.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.Models.Manufacturies;
import ru.gurov.api.Repositoryes.ManufacturiesRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class ManufacturiesController {

    private final ManufacturiesRepository manufacturiesRepository;

    @GetMapping("/manufacturies")
    public ResponseEntity<Object> getAllManufacturies(){
        try {
            Iterable<Manufacturies> manufacturies = manufacturiesRepository.findAll();
            return new ResponseEntity<Object>(manufacturies, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/manufacturies/{id}")
    public ResponseEntity<Object> getManufacturiesById(@PathVariable("id") Long id) {
        try {
            Manufacturies manufacturies = manufacturiesRepository.findById(id).get();
            if(manufacturies != null) {
                return new ResponseEntity<Object>(manufacturies, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/manufacturies/create")
    public ResponseEntity<Object> createManufactiries(@RequestBody Manufacturies manufacturies) {
        try {
            Manufacturies savedManufacturies = manufacturiesRepository.save(manufacturies);
            return new ResponseEntity<Object>(savedManufacturies, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/manufacturies/{id}")
    public ResponseEntity<Object> updateManufacturies(@PathVariable("id") Long id, @RequestBody Manufacturies manufacturies) {
        try {
            manufacturies.setId(id);
            Manufacturies savedManufacturies = manufacturiesRepository.save(manufacturies);
            return new ResponseEntity<Object>(savedManufacturies, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/manufacturies/{id}")
    public ResponseEntity<HttpStatus> deleteManufacturies(@PathVariable("id") Long id) {
        try {
            manufacturiesRepository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
