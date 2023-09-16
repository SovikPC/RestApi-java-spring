package ru.gurov.api.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.DTO.EquipmentDTO;
import ru.gurov.api.Models.Equipment;
import ru.gurov.api.Repositories.EquipmentRepo;

@Service
@RequiredArgsConstructor
public class EquipmentService {
    
    private final EquipmentRepo equipmentRepo;
    private final ModelService modelService;
    private final ResponsibleService responsibleService;
    private final PositionService positionService;
    private final StateService stateService;

    public List<Equipment> show(){
        return equipmentRepo.findAll();
    }

    public Optional<Equipment> showOne(Long id){
        return equipmentRepo.findById(id);
    }

    public Equipment save(EquipmentDTO dto){
        return equipmentRepo.save(Equipment.builder()
        .name(dto.getName())
        .model(modelService.showOne(dto.getId_models()))
        .description(dto.getDescription())
        .responsible(responsibleService.showOne(dto.getId_responsible()))
        .inventory(dto.getInventory())
        .serial(dto.getSerial())
        .position(positionService.showOne(dto.getId_positions()))
        .comments(dto.getComments())
        .price(dto.getPrice())
        .state(stateService.showOne(dto.getId_state()))
        .build());
    }

    public Equipment update(Equipment equipment){
        return equipmentRepo.save(equipment);
    }    

    public void delete(Long id){
        equipmentRepo.deleteById(id);
    }
}
