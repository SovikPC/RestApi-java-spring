package ru.gurov.api.components.responsible;

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
public class Responsible {

    @Id
    @Column(name = "id_responsible")
    @GeneratedValue
    private Integer id;

    @Column(name = "full_name")
    private String full;
}
