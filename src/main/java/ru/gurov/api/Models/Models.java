package ru.gurov.api.Models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Models")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Models {

    @Id
    @Column(name = "id_model")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_model")
    private String name;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "id_manufacturer")
    private Manufacturers manufacturers;
}
