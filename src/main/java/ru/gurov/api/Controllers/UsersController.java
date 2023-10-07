package ru.gurov.api.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gurov.api.Models.Users;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.gurov.api.Repositoryes.UsersRepository;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class UsersController {

    private final UsersRepository usersRepository;

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers(){
        try {
            Iterable<Users> users = usersRepository.findAll();
            return new ResponseEntity<Object>(users, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUsersById(@PathVariable("id") Long id) {
        try {
            Users users = usersRepository.findById(id).get();
            if(users != null) {
                return new ResponseEntity<Object>(users, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/users/create")
    public ResponseEntity<Object> createUsers(@RequestBody Users users) {
        try {
            Users savedUsers = usersRepository.save(users);
            return new ResponseEntity<Object>(savedUsers, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUsers(@PathVariable("id") Long id, @RequestBody Users users) {
        try {
            users.setId(id);
            Users savedUsers = usersRepository.save(users);
            return new ResponseEntity<Object>(savedUsers, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUsers(@PathVariable("id") Long id) {
        try {
            usersRepository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }
    }
}
