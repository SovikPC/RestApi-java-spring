package ru.gurov.api.components.equipment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/equipment")
@CrossOrigin("*")
public class EquipmentController {

    private final EquipmentRepository equipmentRepository;

    @GetMapping
    public ResponseEntity<Object> getAllEquipment(){
        try {
            Iterable<Equipment> equipment = equipmentRepository.findAll();
            return new ResponseEntity<>(equipment, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEquipmentById(@PathVariable("id") Integer id) {
        try {
            Equipment equipment = equipmentRepository.findById(id).orElseThrow();
            return new ResponseEntity<>(equipment, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Object> createEquipment(@RequestBody Equipment equipment) {
        try {
            Equipment savedEquipment = equipmentRepository.save(equipment);
            return new ResponseEntity<>(savedEquipment, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEquipment(@PathVariable("id") Integer id, @RequestBody Equipment equipment) {
        try {
            equipment.setId(id);
            Equipment savedEquipment = equipmentRepository.save(equipment);
            return new ResponseEntity<>(savedEquipment, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEquipment(@PathVariable("id") Integer id) {
        try {
            equipmentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
