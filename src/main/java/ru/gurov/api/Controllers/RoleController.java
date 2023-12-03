package ru.gurov.api.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.Models.ERoles;
import ru.gurov.api.Models.Roles;
import ru.gurov.api.Repositories.RoleRepository;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:2000", allowedHeaders = "*")
public class RoleController {

    private final RoleRepository roleRepository;

    @GetMapping("/roles")
    public ResponseEntity<Object> getAllRoles(){
        try {
            Iterable<Roles> roles = roleRepository.findAll();
            return new ResponseEntity<>(roles, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/roles/{name_role}")
    public ResponseEntity<Object> getRolesByName(@PathVariable("name_role") ERoles name_role){
        try{
            Roles roles = roleRepository.findByName(name_role).orElseThrow();
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
