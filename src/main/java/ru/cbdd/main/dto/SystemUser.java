package ru.cbdd.main.dto;



import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cbdd.main.entitys.Role;
import ru.cbdd.validation.FieldMatch;
//import FieldMatch;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@NoArgsConstructor
@FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
public class SystemUser {

    private Long id;

    @NotNull(message = "not null check")
    @NotEmpty
    private String username;

    @NotNull(message = "is required")
    @NotEmpty
    private String password;

    @NotNull(message = "is required")
    @NotEmpty
    private String matchingPassword;

    private Collection<Role> roles;


}
