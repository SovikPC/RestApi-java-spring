package ru.gurov.api.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.DTO.ResponsibleDTO;
import ru.gurov.api.Models.Responsible;
import ru.gurov.api.Repositories.ResponsibleRepo;

@Service
@RequiredArgsConstructor
public class ResponsibleService {
    
    private final ResponsibleRepo responsibleRepo;

    public List<Responsible> show(){
        return responsibleRepo.findAll();
    }

    public Responsible showOne(Long id){
        return responsibleRepo.findById(id).orElseThrow(()-> new RuntimeException());
    }

    public Responsible save(ResponsibleDTO dto){
        return responsibleRepo.save(Responsible.builder()
        .fio(dto.getFio())
        .build());
    }

    public Responsible update(Responsible responsible){
        return responsibleRepo.save(responsible);
    }

    public void delete(Long id){
        responsibleRepo.deleteById(id);
    }
}
