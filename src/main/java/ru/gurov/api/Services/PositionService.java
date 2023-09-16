package ru.gurov.api.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.DTO.PositionDTO;
import ru.gurov.api.Models.Position;
import ru.gurov.api.Repositories.PositionRepo;

@Service
@RequiredArgsConstructor
public class PositionService {
    
    private final PositionRepo positionRepo;

    public List<Position> show(){
        return positionRepo.findAll();
    }

    public Position showOne(Long id){
        return positionRepo.findById(id).orElseThrow(()-> new RuntimeException());
    }

    public Position save(PositionDTO dto){
        return positionRepo.save(Position.builder()
        .name(dto.getName())
        .build());
    }

    public Position update(Position position){
        return positionRepo.save(position);
    }

    public void delete(Long id){
        positionRepo.deleteById(id);
    }
}
