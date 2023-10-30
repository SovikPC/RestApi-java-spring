package ru.gurov.api.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.Models.Positions;
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
            Iterable<Positions> position = positionRepository.findAll();
            return new ResponseEntity<>(position, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/position/{name}")
    public ResponseEntity<Object> getPositionById(@PathVariable("name") String name) {
        try {
            Positions positions = positionRepository.findByName(name).orElseThrow();
            if(positions != null) {
                return new ResponseEntity<>(positions, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/position")
    public ResponseEntity<Object> createPosition(@RequestBody Positions positions) {
        try {
            Positions savedPositions = positionRepository.save(positions);
            return new ResponseEntity<>(savedPositions, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/position/{id}")
    public ResponseEntity<Object> updatePosition(@PathVariable("id") Long id, @RequestBody Positions positions) {
        try {
            positions.setId_position(id);
            Positions savedPositions = positionRepository.save(positions);
            return new ResponseEntity<>(savedPositions, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/position/{id}")
    public ResponseEntity<HttpStatus> deleteEquipment(@PathVariable("id") Long id) {
        try {
            positionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
