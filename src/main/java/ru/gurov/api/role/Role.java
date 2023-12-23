package ru.gurov.api.role;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gurov.api.role.ERole;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "id_role")
    @GeneratedValue
    private Integer id;

    @Enumerated(EnumType.STRING)
    private ERole name;
}
