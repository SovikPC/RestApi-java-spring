package ru.gurov.api.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.Models.States;
import ru.gurov.api.Repositoryes.StateRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class StateController {

    private final StateRepository stateRepository;

    @GetMapping("/state")
    public ResponseEntity<Object> getAllState(){
        try {
            Iterable<States> state = stateRepository.findAll();
            return new ResponseEntity<>(state, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/state/{name}")
    public ResponseEntity<Object> getStateById(@PathVariable("name") String name) {
        try {
            States states = stateRepository.findByName(name).orElseThrow();
            if(states != null) {
                return new ResponseEntity<>(states, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/state")
    public ResponseEntity<Object> createState(@RequestBody States states) {
        try {
            States savedStates = stateRepository.save(states);
            return new ResponseEntity<>(savedStates, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/state/{id}")
    public ResponseEntity<Object> updateState(@PathVariable("id") Long id, @RequestBody States states) {
        try {
            states.setId_state(id);
            States savedStates = stateRepository.save(states);
            return new ResponseEntity<>(savedStates, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/state/{id}")
    public ResponseEntity<HttpStatus> deleteState(@PathVariable("id") Long id) {
        try {
            stateRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
