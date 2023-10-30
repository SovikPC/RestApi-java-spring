package ru.gurov.api.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gurov.api.Models.ERoles;
//import ru.gurov.api.Models.Roles;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String last_name;
    private String first_name;
    private String father_name;
    private String login;
    private String password;
    private ERoles roles;
}
