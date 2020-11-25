package ru.cbdd.fvf.entitys;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cbdd.fvf.validation.FieldMatch;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
public class SystemUser{

    @NotNull(message = "not null check")
    private String username;

    @NotNull(message = "is required")
    private String password;

    @NotNull(message = "is required")
    private String matchingPassword;

    private List<Role> roles;


}
