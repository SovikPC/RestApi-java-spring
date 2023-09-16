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
@Table(name = "equipment")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {

    @Id
    @Column(name = "id")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_models", referencedColumnName = "id")
    private Model model;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_responsible", referencedColumnName = "id")
    private Responsible responsible;

    @Column(name = "inventory")
    private Long inventory;

    @Column(name = "serial")
    private String serial;

    @ManyToOne
    @JoinColumn(name = "id_positions", referencedColumnName = "id")
    private Position position;

    @Column(name = "comments")
    private String comments;

    @Column(name = "price")
    private Long price;

    @ManyToOne
    @JoinColumn(name = "id_state", referencedColumnName = "id")
    private State state;
}
