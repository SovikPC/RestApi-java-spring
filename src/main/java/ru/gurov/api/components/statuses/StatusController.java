package ru.gurov.api.components.statuses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/status")
@CrossOrigin("*")
public class StatusController {

    private final StatusRepository statusRepository;

    @GetMapping
    public ResponseEntity<Object> getAllState(){
        try {
            Iterable<Status> state = statusRepository.findAll();
            return new ResponseEntity<>(state, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<Object> getStateById(@PathVariable("name") String name) {
        try {
            Status status = statusRepository.findByStatus(name).orElseThrow();
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
