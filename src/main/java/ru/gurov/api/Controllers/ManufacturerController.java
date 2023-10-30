package ru.gurov.api.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.Models.Manufacturers;
import ru.gurov.api.Repositoryes.ManufacturerRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class ManufacturerController {

    private final ManufacturerRepository manufacturerRepository;

    @GetMapping("/manufacturer")
    public ResponseEntity<Object> getAllManufacturer(){
        try {
            Iterable<Manufacturers> manufacturer = manufacturerRepository.findAll();
            return new ResponseEntity<>(manufacturer, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/manufacturer/{name}")
    public ResponseEntity<Object> getManufacturerById(@PathVariable("name") String name) {
        try {
            Manufacturers manufacturers = manufacturerRepository.findByName(name).orElseThrow();
            if(manufacturers != null) {
                return new ResponseEntity<>(manufacturers, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/manufacturer")
    public ResponseEntity<Object> createManufacturer(@RequestBody Manufacturers manufacturers) {
        try {
            Manufacturers saveManufacturers = manufacturerRepository.save(manufacturers);
            return new ResponseEntity<>(saveManufacturers, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/manufacturer/{id}")
    public ResponseEntity<Object> updateManufacturer(@PathVariable("id") Long id, @RequestBody Manufacturers manufacturers) {
        try {
            manufacturers.setId_manufacturer(id);
            Manufacturers savedManufacturers = manufacturerRepository.save(manufacturers);
            return new ResponseEntity<>(savedManufacturers, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/manufacturer/{id}")
    public ResponseEntity<HttpStatus> deleteManufacturer(@PathVariable("id") Long id) {
        try {
            manufacturerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
