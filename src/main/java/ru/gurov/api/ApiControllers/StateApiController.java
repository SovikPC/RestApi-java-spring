package ru.gurov.api.ApiControllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.DTO.StateDTO;
import ru.gurov.api.Models.State;
import ru.gurov.api.Services.StateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/state")
public class StateApiController {
    
    private final StateService stateService;

    @GetMapping()
    public List<State> getStates(){
        return stateService.show();
    }

    @PostMapping("/create")
    public ResponseEntity<State> create(@RequestBody StateDTO stateDTO) {        
        return new ResponseEntity<State>(stateService.save(stateDTO), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<State> update(@RequestBody State state) {        
        return new ResponseEntity<State>(stateService.update(state), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        stateService.delete(id);
        return HttpStatus.OK;
    }
    
    
}
