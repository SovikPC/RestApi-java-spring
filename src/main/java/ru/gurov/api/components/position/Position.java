package ru.gurov.api.components.position;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Positions")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    
    @Id
    @Column(name = "id_position")
    @GeneratedValue
    private Integer id;

    @Column(name = "name_position")
    private String name;
    
}
