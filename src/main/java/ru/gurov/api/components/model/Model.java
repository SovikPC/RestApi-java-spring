package ru.gurov.api.components.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gurov.api.components.manufacturer.Manufacturer;

@Data
@Entity
@Table(name = "Models")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Model {

    @Id
    @Column(name = "id_model")
    @GeneratedValue
    private Integer id;

    @Column(name = "name_model")
    private String name;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "id_manufacturer")
    private Manufacturer manufacturer;
}
