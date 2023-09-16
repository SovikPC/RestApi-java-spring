package ru.gurov.api.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.gurov.api.DTO.StateDTO;
import ru.gurov.api.Models.State;
import ru.gurov.api.Repositories.StateRepo;

@Service
@RequiredArgsConstructor
public class StateService {
    
    private final StateRepo stateRepo;

    public List<State> show(){
        return stateRepo.findAll();
    }

    public State showOne(Long id){
        return stateRepo.findById(id).orElseThrow(()-> new RuntimeException());
    }

    public State save(StateDTO dto){
        return stateRepo.save(State.builder()
        .name(dto.getName())
        .build());
    }

    public State update(State state){
        return stateRepo.save(state);
    }

    public void delete(Long id){
        stateRepo.deleteById(id);
    }
}
