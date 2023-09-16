package ru.gurov.api.ApiControllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.DTO.PositionDTO;
import ru.gurov.api.Models.Position;
import ru.gurov.api.Services.PositionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/position")
public class PositionApiController {
    
    private final PositionService positionService;

    @GetMapping()
    public List<Position> getPosition(){
        return positionService.show();
    }

    @PostMapping("/create")
    public ResponseEntity<Position> create(@RequestBody PositionDTO positionDTO) {
        return new ResponseEntity<>(positionService.save(positionDTO), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Position> update(@RequestBody Position position) {        
        return new ResponseEntity<>(positionService.update(position), HttpStatus.OK);
    }

        @DeleteMapping("/delete/{id}")
        public HttpStatus delete(@PathVariable Long id) {
            positionService.delete(id);
            return HttpStatus.OK;
        }
    
}
