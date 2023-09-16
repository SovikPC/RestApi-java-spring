package ru.gurov.api.ApiControllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.DTO.RolesDTO;
import ru.gurov.api.Models.Roles;
import ru.gurov.api.Services.RolesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/roles")
public class RolesApiController {
    
    private final RolesService rolesService;

    @GetMapping()
    public List<Roles> getRoles(){
        return rolesService.show();
    }

    @PostMapping("/create")
    public ResponseEntity<Roles> create(@RequestBody RolesDTO rolesDTO) {        
        return new ResponseEntity<>(rolesService.save(rolesDTO), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Roles> update(@RequestBody Roles roles) {        
        return new ResponseEntity<>(rolesService.update(roles), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        rolesService.delete(id);
        return HttpStatus.OK;
    }
        
}
