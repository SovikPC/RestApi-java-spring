package ru.gurov.api.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.Models.Roles;
import ru.gurov.api.Repositoryes.RolesRepository;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class RolesController {

    private final RolesRepository rolesRepository;

    @GetMapping("/roles")
    public ResponseEntity<Object> getAllRoles(){
        try {
            Iterable<Roles> roles = rolesRepository.findAll();
            return new ResponseEntity<>(roles, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/roles/{name}")
    public ResponseEntity<Object> getRolesByName(@PathVariable("name") String name){
        try{
            Roles roles = rolesRepository.findByName(name).get();
            if(roles != null) {
                return new ResponseEntity<>(roles, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
