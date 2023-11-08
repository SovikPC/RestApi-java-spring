package ru.gurov.api.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.gurov.api.Models.Users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.gurov.api.Repositories.UserRepository;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers(){
        try {
            Iterable<Users> users = userRepository.findAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUsersById(@PathVariable("id") Long id) {
        try {
            Users users = userRepository.findById(id).orElseThrow();
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
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String hashPassword = bCryptPasswordEncoder.encode(users.getPassword());
            users.setPassword(hashPassword);
            Users savedUsers = userRepository.save(users);
            return new ResponseEntity<>(savedUsers, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUsers(@PathVariable("id") Long id, @RequestBody Users users) {
        try {
            users.setId(id);
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String hashPassword = bCryptPasswordEncoder.encode(users.getPassword());
            users.setPassword(hashPassword);
            Users savedUsers = userRepository.save(users);
            return new ResponseEntity<>(savedUsers, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUsers(@PathVariable("id") Long id) {
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
