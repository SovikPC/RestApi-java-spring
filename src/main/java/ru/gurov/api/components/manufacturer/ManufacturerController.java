package ru.gurov.api.components.manufacturer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/manufacturer")
@CrossOrigin("*")
public class ManufacturerController {

    private final ManufacturerRepository manufacturerRepository;

    @GetMapping
    public ResponseEntity<Object> getAllManufacturer(){
        try {
            Iterable<Manufacturer> manufacturer = manufacturerRepository.findAll();
            return new ResponseEntity<>(manufacturer, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{name_manufacturer}")
    public ResponseEntity<Object> getManufacturerById(@PathVariable("name_manufacturer") String name_manufacturer) {
        try {
            Manufacturer manufacturer = manufacturerRepository.findByName(name_manufacturer).orElseThrow();
            if(manufacturer != null) {
                return new ResponseEntity<>(manufacturer, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Object> createManufacturer(@RequestBody Manufacturer manufacturer) {
        try {
            Manufacturer saveManufacturer = manufacturerRepository.save(manufacturer);
            return new ResponseEntity<>(saveManufacturer, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
