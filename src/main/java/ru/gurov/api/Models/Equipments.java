package ru.gurov.api.Models;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Long id_equipment;

    @Column(name = "name_equipment")
    private String name;

    @ManyToOne
    @JoinColumn(name = "models_id", referencedColumnName = "id_model")
    private Models models;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "responsible_id", referencedColumnName = "id_responsible")
    private Responsible_persons responsiblePersons;

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
    @JoinColumn(name = "state_id", referencedColumnName = "id_state")
    private States states;
}
