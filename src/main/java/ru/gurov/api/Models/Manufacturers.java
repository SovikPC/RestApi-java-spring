package ru.gurov.api.Models;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Long id_manufacturer;

    @Column(name = "name_manufacturer")
    private String name;
}
