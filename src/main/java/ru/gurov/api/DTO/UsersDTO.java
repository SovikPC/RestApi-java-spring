package ru.gurov.api.DTO;

import lombok.Data;

@Data
public class UsersDTO {
    private String last_name;
    private String first_name;
    private String father_name;
    private String login;
    private String password;
    private Long id_role;
}
