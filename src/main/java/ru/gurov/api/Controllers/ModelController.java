package ru.gurov.api.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import ru.gurov.api.Models.Models;
import ru.gurov.api.Repositories.ModelRepository;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class ModelController {

    private final ModelRepository modelRepository;

    @GetMapping("/model")
    public ResponseEntity<Object> getAllModel(){
        try {
            Iterable<Models> models = modelRepository.findAll();
            return new ResponseEntity<>(models, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/model/{name}")
    public ResponseEntity<Object> getModelById(@PathVariable("name") String name) {
        try {
            Models models = modelRepository.findByName(name).orElseThrow();
            if(models != null) {
                return new ResponseEntity<>(models, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/model")
    public ResponseEntity<Object> createModel(@RequestBody Models models) {
        try {
            Models savedModels = modelRepository.save(models);
            return new ResponseEntity<>(savedModels, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/model/{id}")
    public ResponseEntity<Object> updateModel(@PathVariable("id") Long id, @RequestBody Models models) {
        try {
            models.setId(id);
            Models savedModels = modelRepository.save(models);
            return new ResponseEntity<>(savedModels, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/model/{id}")
    public ResponseEntity<HttpStatus> deleteModel(@PathVariable("id") Long id) {
        try {
            modelRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
