package ru.gurov.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")

public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers(){
        try {
            Iterable<User> user = userRepository.findAll();
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUsersById(@PathVariable("id") Integer id) {
        try {
            User user = userRepository.findById(id).orElseThrow();
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUsers(@RequestBody User users) {
        try
        {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String hashPassword = bCryptPasswordEncoder.encode(users.getPassword());
            users.setPassword(hashPassword);
            User savedUser = userRepository.save(users);
            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUsers(@PathVariable("id") Integer id, @RequestBody User user) {
        try {
            user.setId(id);
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String hashPassword = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(hashPassword);
            User savedUser = userRepository.save(user);
            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUsers(@PathVariable("id") Integer id) {
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
