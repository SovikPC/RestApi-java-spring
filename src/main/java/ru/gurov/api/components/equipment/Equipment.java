package ru.gurov.api.components.equipment;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gurov.api.components.statuses.Status;
import ru.gurov.api.components.model.Model;
import ru.gurov.api.components.position.Position;
import ru.gurov.api.components.responsible.Responsible;

@Data
@Entity
@Table(name = "Equipments")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {

    @Id
    @Column(name = "id_equipment")
    @GeneratedValue
    private Integer id;

    @Column(name = "name_equipment")
    private String name;

    @ManyToOne
    @JoinColumn(name = "models_id", referencedColumnName = "id_model")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "responsible_id", referencedColumnName = "id_responsible")
    private Responsible responsible;

    @Column(name = "inventory")
    private Long inventory;

    @Column(name = "serial")
    private String serial;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id_position")
    private Position position;

    @Column(name = "comment")
    private String comments;

    @Column(name = "price")
    private Long price;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id_status")
    private Status status;
}
