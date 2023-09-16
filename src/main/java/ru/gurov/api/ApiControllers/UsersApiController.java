package ru.gurov.api.ApiControllers;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.DTO.UsersDTO;
import ru.gurov.api.Models.Users;
import ru.gurov.api.Services.UsersService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UsersApiController {
    
    private final UsersService usersService;

    @GetMapping()
    public List<Users> getUsers(){
        return usersService.show();
    }

    @PostMapping("/create")
    public ResponseEntity<Users> create(@RequestBody UsersDTO usersDTO) {
        return new ResponseEntity<>(usersService.save(usersDTO), HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Users> update(@RequestBody Users users) {        
        return new ResponseEntity<Users>(usersService.update(users), HttpStatus.OK);
    }

        @DeleteMapping("/delete/{id}")
        public HttpStatus delete(@PathVariable Long id) {
            usersService.delete(id);
            return HttpStatus.OK;
        }
    
}
