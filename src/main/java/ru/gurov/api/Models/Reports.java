package ru.gurov.api.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Reports")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reports {

    @Id
    @Column(name = "id_report")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_create")
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id_user")
    private Users users;

    @Column(name = "path")
    private String path;
}
