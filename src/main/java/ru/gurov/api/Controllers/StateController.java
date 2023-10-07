package ru.gurov.api.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.Models.State;
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
            Iterable<State> state = stateRepository.findAll();
            return new ResponseEntity<Object>(state, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/state/{id}")
    public ResponseEntity<Object> getStateById(@PathVariable("id") Long id) {
        try {
            State state = stateRepository.findById(id).get();
            if(state != null) {
                return new ResponseEntity<Object>(state, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/state/create")
    public ResponseEntity<Object> createState(@RequestBody State state) {
        try {
            State savedState = stateRepository.save(state);
            return new ResponseEntity<Object>(savedState, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/state/{id}")
    public ResponseEntity<Object> updateState(@PathVariable("id") Long id, @RequestBody State state) {
        try {
            state.setId(id);
            State savedState = stateRepository.save(state);
            return new ResponseEntity<Object>(savedState, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/state/{id}")
    public ResponseEntity<HttpStatus> deleteState(@PathVariable("id") Long id) {
        try {
            stateRepository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
