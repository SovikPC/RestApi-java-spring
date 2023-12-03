package ru.gurov.api.Models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Equipments")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Equipments {

    @Id
    @Column(name = "id_equipment")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_equipment")
    private String name;

    @ManyToOne
    @JoinColumn(name = "models_id", referencedColumnName = "id_model")
    private Models models;

    @ManyToOne
    @JoinColumn(name = "responsible_id", referencedColumnName = "id_responsible")
    private Responsible_persons responsible;

    @Column(name = "inventory")
    private Long inventory;

    @Column(name = "serial")
    private String serial;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id_position")
    private Positions positions;

    @Column(name = "comment")
    private String comments;

    @Column(name = "price")
    private Long price;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id_status")
    private Statuses statuses;
}
