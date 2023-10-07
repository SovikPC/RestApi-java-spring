package ru.gurov.api.Controllers;

import java.util.List;

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
            return new ResponseEntity<Object>(roles, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<Object> getRolesById(@PathVariable("id") Long id) {
        try {
            Roles roles = rolesRepository.findById(id).get();
            if(roles != null) {
                return new ResponseEntity<Object>(roles, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/roles/create")
    public ResponseEntity<Object> createRoles(@RequestBody Roles roles) {
        try {
            Roles savedRoles = rolesRepository.save(roles);
            return new ResponseEntity<Object>(savedRoles, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/roles/{id}")
    public ResponseEntity<Object> updateRoles(@PathVariable("id") Long id, @RequestBody Roles roles) {
        try {
            roles.setId(id);
            Roles savedRoles = rolesRepository.save(roles);
            return new ResponseEntity<Object>(savedRoles, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/roles/{id}")
    public ResponseEntity<HttpStatus> deleteRoles(@PathVariable("id") Long id) {
        try {
            rolesRepository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }
    }
        
}
