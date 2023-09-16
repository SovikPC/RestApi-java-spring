package ru.gurov.api.ApiControllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ru.gurov.api.DTO.ModelDTO;
import ru.gurov.api.Models.Model;
import ru.gurov.api.Services.ModelService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@AllArgsConstructor
@RequestMapping("/api/model")
public class ModelApiController {

    private final ModelService modelService;

    @GetMapping()
    public List<Model> getModel(){
        return modelService.show();
    }

    @GetMapping("/{id}")
    public Model getOneModel(@PathVariable Long id) {
        return modelService.showOne(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Model> create(@RequestBody ModelDTO dto) {
        return new ResponseEntity<>(modelService.save(dto), HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Model> putMethodName(@RequestBody Model model) {        
        return new ResponseEntity<>(modelService.update(model), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable Long id){
        modelService.delete(id);
        return HttpStatus.OK;
    }
}
