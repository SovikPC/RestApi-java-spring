package ru.gurov.api.components.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/api/model")
@CrossOrigin("*")
public class ModelController {

    private final ModelRepository modelRepository;

    @GetMapping
    public ResponseEntity<Object> getAllModel(){
        try {
            Iterable<Model> models = modelRepository.findAll();
            return new ResponseEntity<>(models, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<Object> getModelById(@PathVariable("name") String name) {
        try {
            Model model = modelRepository.findByName(name).orElseThrow();
            if(model != null) {
                return new ResponseEntity<>(model, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Object> createModel(@RequestBody Model model) {
        try {
            Model savedModel = modelRepository.save(model);
            return new ResponseEntity<>(savedModel, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
