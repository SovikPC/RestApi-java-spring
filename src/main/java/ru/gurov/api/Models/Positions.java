package ru.gurov.api.Models;

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
public class Positions {
    
    @Id
    @Column(name = "id_position")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_position")
    private String name;
    
}
