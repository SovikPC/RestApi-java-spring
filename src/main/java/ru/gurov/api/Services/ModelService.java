package ru.gurov.api.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.DTO.ModelDTO;
import ru.gurov.api.Models.Model;
import ru.gurov.api.Repositories.ModelRepo;

@Service
@RequiredArgsConstructor
public class ModelService {
    
    private final ModelRepo modelRepo;
    private final ManufacturiesService manufacturiesService;

    public List<Model> show(){
         return modelRepo.findAll();
    }

    public Model showOne(Long id){
        return modelRepo.findById(id).orElseThrow(()-> new RuntimeException());
    }

    public Model save(ModelDTO dto){
        return modelRepo.save(Model.builder()
        .name(dto.getName())
        .manufacturies(manufacturiesService.showById(dto.getId_manufacturies()))
        .build());
    }

    public Model update(Model model){
        return modelRepo.save(model);
    }

    public void delete(Long id){
        modelRepo.deleteById(id);
    }
}
