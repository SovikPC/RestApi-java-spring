package ru.gurov.api.ApiControllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.DTO.EquipmentDTO;
import ru.gurov.api.Models.Equipment;
import ru.gurov.api.Services.EquipmentService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/equipment")
public class EquipmentApiController {
    
    private final EquipmentService equipmentService;

    @GetMapping()
    public List<Equipment> getEquipments(){
        return equipmentService.show();
    }

    @PostMapping("/create")
    public ResponseEntity<Equipment> create(@RequestBody EquipmentDTO equipmentDTO) {    
        return new ResponseEntity<>(equipmentService.save(equipmentDTO), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Equipment> update(@RequestBody Equipment equipment) {        
        return new ResponseEntity<>(equipmentService.update(equipment), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable Long id){
        equipmentService.delete(id);
        return HttpStatus.OK;
    }
}
