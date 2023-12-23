package ru.gurov.api.role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/roles")
@CrossOrigin("*")
public class RoleController {

    private final RoleRepository roleRepository;

    @GetMapping
    public ResponseEntity<Object> getAllRoles(){
        try {
            Iterable<Role> roles = roleRepository.findAll();
            return new ResponseEntity<>(roles, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<Object> getRolesByName(@PathVariable("name") ERole name){
        try{
            Role roles = roleRepository.findByName(name).orElseThrow();
            return new ResponseEntity<>(roles, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
