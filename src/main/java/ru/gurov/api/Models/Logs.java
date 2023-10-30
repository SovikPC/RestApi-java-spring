package ru.gurov.api.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "Logs")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Logs {

    @Id
    @Column(name = "id_log")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Long id_log;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id_user")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "operation_id", referencedColumnName = "id_operation")
    private Operations operations;

    @ManyToOne
    @JoinColumn(name = "equipment_id", referencedColumnName = "id_equipment")
    private Equipments equipments;
}
