package ru.gurov.api.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.Models.Statuses;
import ru.gurov.api.Repositories.StatusRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:2000", allowedHeaders = "*")
public class StatusController {

    private final StatusRepository statusRepository;

    @GetMapping("/status")
    public ResponseEntity<Object> getAllState(){
        try {
            Iterable<Statuses> state = statusRepository.findAll();
            return new ResponseEntity<>(state, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/status/{name}")
    public ResponseEntity<Object> getStateById(@PathVariable("name") String name) {
        try {
            Statuses statuses = statusRepository.findByStatus(name).orElseThrow();
            if(statuses != null) {
                return new ResponseEntity<>(statuses, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/status")
    public ResponseEntity<Object> createState(@RequestBody Statuses statuses) {
        try {
            Statuses savedStatuses = statusRepository.save(statuses);
            return new ResponseEntity<>(savedStatuses, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Object> updateState(@PathVariable("id") Long id, @RequestBody Statuses statuses) {
        try {
            statuses.setId(id);
            Statuses savedStatuses = statusRepository.save(statuses);
            return new ResponseEntity<>(savedStatuses, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/status/{id}")
    public ResponseEntity<HttpStatus> deleteState(@PathVariable("id") Long id) {
        try {
            statusRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
