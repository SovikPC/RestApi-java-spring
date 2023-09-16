package ru.gurov.api.ApiControllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.DTO.ManufacturiesDTO;
import ru.gurov.api.Models.Manufacturies;
import ru.gurov.api.Services.ManufacturiesService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/manufacturies")
public class ManufacturiesApiController {

    private final ManufacturiesService manufacturiesService;

    @GetMapping()
    public List<Manufacturies> getManufacturies(){
        return manufacturiesService.show();
    }

    @PostMapping("/create")
    public ResponseEntity<Manufacturies> create(@RequestBody ManufacturiesDTO manufacturiesDTO) {
        return new ResponseEntity<>(manufacturiesService.save(manufacturiesDTO), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Manufacturies> update(@RequestBody Manufacturies manufacturies) {    
        return new ResponseEntity<>(manufacturiesService.update(manufacturies), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        manufacturiesService.delete(id);
        return HttpStatus.OK;
    }
    
}
