package ru.gurov.api.Models;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Long id_responsible;

    @Column(name = "full_name")
    private String fio;
    
}
