package ru.gurov.api.components.manufacturer;

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
public class Manufacturer {
    @Id
    @Column(name = "id_manufacturer")
    @GeneratedValue
    private Integer id;

    @Column(name = "name_manufacturer")
    private String name;
}
