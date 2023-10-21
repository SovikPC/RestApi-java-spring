package ru.gurov.api.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import ru.gurov.api.Models.Model;
import ru.gurov.api.Repositoryes.ManufacturiesRepository;
import ru.gurov.api.Repositoryes.ModelRepository;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class ModelController {

    private final ModelRepository modelRepository;

    @GetMapping("/model")
    public ResponseEntity<Object> getAllModel(){
        try {
            Iterable<Model> models = modelRepository.findAll();
            return new ResponseEntity<Object>(models, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/model/{name}")
    public ResponseEntity<Object> getModelById(@PathVariable("name") String name) {
        try {
            Model model = modelRepository.findByName(name).get();
            if(model != null) {
                return new ResponseEntity<Object>(model, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/model")
    public ResponseEntity<Object> createModel(@RequestBody Model model) {
        try {
            Model savedModel = modelRepository.save(model);
            return new ResponseEntity<Object>(savedModel, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/model/{id}")
    public ResponseEntity<Object> updateModel(@PathVariable("id") Long id, @RequestBody Model model) {
        try {
            model.setId(id);
            Model savedModel = modelRepository.save(model);
            return new ResponseEntity<Object>(savedModel, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/model/{id}")
    public ResponseEntity<HttpStatus> deleteModel(@PathVariable("id") Long id) {
        try {
            modelRepository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }
    }
}
