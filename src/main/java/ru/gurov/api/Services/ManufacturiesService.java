package ru.gurov.api.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.DTO.ManufacturiesDTO;
import ru.gurov.api.Models.Manufacturies;
import ru.gurov.api.Repositories.ManufacturiesRepo;

@Service
@RequiredArgsConstructor
public class ManufacturiesService {
    
    private final ManufacturiesRepo manufacturiesRepo;

    public List<Manufacturies> show(){
        return manufacturiesRepo.findAll();
    }

    public Manufacturies showById(Long id){
        return manufacturiesRepo.findById(id).orElseThrow(()-> new RuntimeException());
    }

    public Manufacturies save(ManufacturiesDTO dto){
        return manufacturiesRepo.save(Manufacturies.builder()
        .name(dto.getName())
        .build());
    }

    public Manufacturies update(Manufacturies manufacturies){
        return manufacturiesRepo.save(manufacturies);
    }

    public void delete(Long id){
        manufacturiesRepo.deleteById(id);
    }
}
