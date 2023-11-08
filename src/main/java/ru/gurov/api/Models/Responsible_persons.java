package ru.gurov.api.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Responsible_persons")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Responsible_persons {

    @Id
    @Column(name = "id_responsible")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String full;
}
