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
            return new ResponseEntity<>(state, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/state/{name}")
    public ResponseEntity<Object> getStateById(@PathVariable("name") String name) {
        try {
            State state = stateRepository.findByName(name).get();
            if(state != null) {
                return new ResponseEntity<>(state, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/state")
    public ResponseEntity<Object> createState(@RequestBody State state) {
        try {
            State savedState = stateRepository.save(state);
            return new ResponseEntity<>(savedState, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/state/{id}")
    public ResponseEntity<Object> updateState(@PathVariable("id") Long id, @RequestBody State state) {
        try {
            state.setId(id);
            State savedState = stateRepository.save(state);
            return new ResponseEntity<>(savedState, HttpStatus.OK);
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
