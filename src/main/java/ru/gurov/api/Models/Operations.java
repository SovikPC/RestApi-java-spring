package ru.gurov.api.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "Operations")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Operations {

    @Id
    @Column(name = "id_operation")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Long id_operation;

    @Column(name = "operation")
    private String operation;
}
