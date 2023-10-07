package ru.gurov.api.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.Models.Equipment;
import ru.gurov.api.Repositoryes.EquipmentRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class EquipmentController {

    private final EquipmentRepository equipmentRepository;

    @GetMapping("/equipment")
    public ResponseEntity<Object> getAllEquipment(){
        try {
            Iterable<Equipment> equipment = equipmentRepository.findAll();
            return new ResponseEntity<Object>(equipment, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/equipment/{id}")
    public ResponseEntity<Object> getEquipmentById(@PathVariable("id") Long id) {
        try {
            Equipment equipment = equipmentRepository.findById(id).get();
            if(equipment != null) {
                return new ResponseEntity<Object>(equipment, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/equipment/create")
    public ResponseEntity<Object> createEquipment(@RequestBody Equipment equipment) {
        try {
            Equipment savedEquipment = equipmentRepository.save(equipment);
            return new ResponseEntity<Object>(savedEquipment, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/equipment/{id}")
    public ResponseEntity<Object> updateEquipment(@PathVariable("id") Long id, @RequestBody Equipment equipment) {
        try {
            equipment.setId(id);
            Equipment savedEquipment = equipmentRepository.save(equipment);
            return new ResponseEntity<Object>(savedEquipment, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/equipment/{id}")
    public ResponseEntity<HttpStatus> deleteEquipment(@PathVariable("id") Long id) {
        try {
            equipmentRepository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }
    }
}
