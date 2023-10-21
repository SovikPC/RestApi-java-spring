package ru.gurov.api.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gurov.api.Models.Users;

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
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUsersById(@PathVariable("id") Long id) {
        try {
            Users users = usersRepository.findById(id).get();
            if(users != null) {
                return new ResponseEntity<>(users, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUsers(@RequestBody Users users) {
        try
        {
            Users savedUsers = usersRepository.save(users);
            return new ResponseEntity<>(savedUsers, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUsers(@PathVariable("id") Long id, @RequestBody Users users) {
        try {
            users.setId(id);
            Users savedUsers = usersRepository.save(users);
            return new ResponseEntity<>(savedUsers, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUsers(@PathVariable("id") Long id) {
        try {
            usersRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
