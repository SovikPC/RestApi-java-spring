package ru.gurov.api.Models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Manufacturers")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturers {
    @Id
    @Column(name = "id_manufacturer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_manufacturer")
    private String name;
}
