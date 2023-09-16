package ru.gurov.api.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.DTO.RolesDTO;
import ru.gurov.api.Models.Roles;
import ru.gurov.api.Repositories.RolesRepo;

@Service
@RequiredArgsConstructor
public class RolesService {
    
    private final RolesRepo rolesRepo;

    public List<Roles> show(){
        return rolesRepo.findAll();
    }

    public Roles showOne(Long id){
        return rolesRepo.findById(id).orElseThrow(()-> new RuntimeException());
    }

    public Roles save(RolesDTO dto){
        return rolesRepo.save(Roles.builder()
        .name(dto.getName())
        .build());
    }

    public Roles update(Roles roles){
        return rolesRepo.save(roles);
    }

    public void delete(Long id){
        rolesRepo.deleteById(id);
    }
}
