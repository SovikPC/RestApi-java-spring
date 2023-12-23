package ru.gurov.api.components.responsible;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/responsible")
@CrossOrigin("*")
public class ResponsibleController {
    private final ResponsibleRepository responsibleRepository;

    @GetMapping
    public ResponseEntity<Object> getAllResponsible(){
        try {
            Iterable<Responsible> responsible = responsibleRepository.findAll();
            return new ResponseEntity<>(responsible, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{fio}")
    public ResponseEntity<Object> getResponsibleById(@PathVariable("fio") String fio) {
        try {
            Responsible responsible = responsibleRepository.findByFull(fio).orElseThrow();
            return new ResponseEntity<>(responsible, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Object> createResponsible(@RequestBody Responsible responsible) {
        try {
            Responsible savedResponsible = responsibleRepository.save(responsible);
            return new ResponseEntity<>(savedResponsible, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
