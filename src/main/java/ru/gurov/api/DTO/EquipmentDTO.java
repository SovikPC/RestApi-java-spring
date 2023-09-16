package ru.gurov.api.DTO;

import lombok.Data;

@Data
public class EquipmentDTO {
    private String name;
    private Long id_models;
    private String description;
    private Long id_responsible;
    private Long inventory;
    private String serial;
    private Long id_positions;
    private String comments;
    private Long price;
    private Long id_state;
}
