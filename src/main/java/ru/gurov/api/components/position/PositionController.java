package ru.gurov.api.components.position;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/position")
@CrossOrigin("*")
public class PositionController {

    private final PositionRepository positionRepository;

    @GetMapping
    public ResponseEntity<Object> getAllPosition(){
        try {
            Iterable<Position> position = positionRepository.findAll();
            return new ResponseEntity<>(position, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<Object> getPositionById(@PathVariable("name") String name) {
        try {
            Position position = positionRepository.findByName(name).orElseThrow();
            if(position != null) {
                return new ResponseEntity<>(position, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Object> createPosition(@RequestBody Position position) {
        try {
            Position savedPosition = positionRepository.save(position);
            return new ResponseEntity<>(savedPosition, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
