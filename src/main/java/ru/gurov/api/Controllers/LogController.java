package ru.gurov.api.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gurov.api.Models.Equipment;
import ru.gurov.api.Models.Log;
import ru.gurov.api.Repositoryes.LogRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
@RequiredArgsConstructor
public class LogController {

    private final LogRepository logRepository;

    @GetMapping("/log")
    public ResponseEntity<Object> getAllLog(){
        try {
            Iterable<Log> log = logRepository.findAll();
            return new ResponseEntity<>(log, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
