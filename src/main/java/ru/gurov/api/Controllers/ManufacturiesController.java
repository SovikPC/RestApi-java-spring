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
            return new ResponseEntity<>(manufacturies, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/manufacturies/{name}")
    public ResponseEntity<Object> getManufacturiesById(@PathVariable("name") String name) {
        try {
            Manufacturies manufacturies = manufacturiesRepository.findByName(name).get();
            if(manufacturies != null) {
                return new ResponseEntity<>(manufacturies, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/manufacturies")
    public ResponseEntity<Object> createManufactiries(@RequestBody Manufacturies manufacturies) {
        try {
            Manufacturies saveManufacturies = manufacturiesRepository.save(manufacturies);
            return new ResponseEntity<>(saveManufacturies, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/manufacturies/{id}")
    public ResponseEntity<Object> updateManufacturies(@PathVariable("id") Long id, @RequestBody Manufacturies manufacturies) {
        try {
            manufacturies.setId(id);
            Manufacturies savedManufacturies = manufacturiesRepository.save(manufacturies);
            return new ResponseEntity<>(savedManufacturies, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/manufacturies/{id}")
    public ResponseEntity<HttpStatus> deleteManufacturies(@PathVariable("id") Long id) {
        try {
            manufacturiesRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
