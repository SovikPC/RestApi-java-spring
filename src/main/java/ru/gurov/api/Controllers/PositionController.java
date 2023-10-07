package ru.gurov.api.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.Models.Position;
import ru.gurov.api.Repositoryes.PositionRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class PositionController {

    private final PositionRepository positionRepository;

    @GetMapping("/position")
    public ResponseEntity<Object> getAllPosition(){
        try {
            Iterable<Position> position = positionRepository.findAll();
            return new ResponseEntity<Object>(position, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/position/{id}")
    public ResponseEntity<Object> getPositionById(@PathVariable("id") Long id) {
        try {
            Position position = positionRepository.findById(id).get();
            if(position != null) {
                return new ResponseEntity<Object>(position, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/position/create")
    public ResponseEntity<Object> createPosition(@RequestBody Position position) {
        try {
            Position savedPosition = positionRepository.save(position);
            return new ResponseEntity<Object>(savedPosition, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/position/{id}")
    public ResponseEntity<Object> updatePosition(@PathVariable("id") Long id, @RequestBody Position position) {
        try {
            position.setId(id);
            Position savedPosition = positionRepository.save(position);
            return new ResponseEntity<Object>(savedPosition, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/position/{id}")
    public ResponseEntity<HttpStatus> deleteEquipment(@PathVariable("id") Long id) {
        try {
            positionRepository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }
    }
}
