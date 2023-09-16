package ru.gurov.api.ApiControllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.DTO.ResponsibleDTO;
import ru.gurov.api.Models.Responsible;
import ru.gurov.api.Services.ResponsibleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/responsible")
public class ResponsibleApiController {
    
    private final ResponsibleService responsibleService;

    @GetMapping()
    public List<Responsible> getResponsibles(){
        return responsibleService.show();
    }

    @PostMapping("/create")
    public ResponseEntity<Responsible> create(@RequestBody ResponsibleDTO responsibleDTO) {        
        return new ResponseEntity<>(responsibleService.save(responsibleDTO), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Responsible> update(@RequestBody Responsible responsible) {
        return new ResponseEntity<>(responsibleService.update(responsible), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        responsibleService.delete(id);
        return HttpStatus.OK;
    }
    
    
}
