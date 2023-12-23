package ru.gurov.api.components.statuses;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Statuses")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Status {
    @Id
    @Column(name = "id_status")
    @GeneratedValue
    private Integer id;

    @Column(name = "status")
    private String status;
}
