package ru.gurov.api.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.DTO.UsersDTO;
import ru.gurov.api.Models.Users;
import ru.gurov.api.Repositories.UsersRepo;

@Service
@RequiredArgsConstructor
public class UsersService {
    
    private final UsersRepo usersRepo;
    private final RolesService rolesService;

    public List<Users> show(){
        return usersRepo.findAll();
    }

    public Users showOne(Long id){
        return usersRepo.findById(id).orElseThrow(()-> new RuntimeException());
    }

    public Users save(UsersDTO dto){
        return usersRepo.save(Users.builder()
        .last_name(dto.getLast_name())
        .first_name(dto.getFirst_name())
        .father_name(dto.getFather_name())
        .login(dto.getLogin())
        .password(dto.getPassword())
        .roles(rolesService.showOne(dto.getId_role()))
        .build());
    }

    public Users update(Users users){
        return usersRepo.save(users);
    }

    public void delete(Long id){
        usersRepo.deleteById(id);
    }
}
