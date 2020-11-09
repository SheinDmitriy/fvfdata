package ru.cbdd.fvf.entitys;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.cbdd.fvf.validation.FieldMatch;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
public class SystemUser extends AbstractEntity{

    @NotNull(message = "not null check")
    @NotEmpty
    private String username;

    @NotNull(message = "is required")
    @NotEmpty
    private String password;

    @NotNull(message = "is required")
    @NotEmpty
    private String matchingPassword;

    private List<Role> roles;


}
