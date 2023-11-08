package ru.gurov.api.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.Models.Equipments;
import ru.gurov.api.Repositories.EquipmentRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class EquipmentController {

    private final EquipmentRepository equipmentRepository;

    @GetMapping("/equipment")
    public ResponseEntity<Object> getAllEquipment(){
        try {
            Iterable<Equipments> equipment = equipmentRepository.findAll();
            return new ResponseEntity<>(equipment, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/equipment/{id}")
    public ResponseEntity<Object> getEquipmentById(@PathVariable("id") Long id) {
        try {
            Equipments equipments = equipmentRepository.findById(id).orElseThrow();
            return new ResponseEntity<>(equipments, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/equipment")
    public ResponseEntity<Object> createEquipment(@RequestBody Equipments equipments) {
        try {
            Equipments savedEquipments = equipmentRepository.save(equipments);
            return new ResponseEntity<>(savedEquipments, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/equipment/{id}")
    public ResponseEntity<Object> updateEquipment(@PathVariable("id") Long id, @RequestBody Equipments equipments) {
        try {
            equipments.setId(id);
            Equipments savedEquipments = equipmentRepository.save(equipments);
            return new ResponseEntity<>(savedEquipments, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/equipment/{id}")
    public ResponseEntity<HttpStatus> deleteEquipment(@PathVariable("id") Long id) {
        try {
            equipmentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
