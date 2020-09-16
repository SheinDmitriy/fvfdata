package ru.cbdd.fvf.entites;



import lombok.Data;
import lombok.NoArgsConstructor;
//import ru.cbdd.fvf.validation.FieldMatch;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Data
//@NoArgsConstructor
//@FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
public class SystemUser {

    private Long id;

//    @NotNull(message = "not null check")
    @NotEmpty
    private String username;

//    @NotNull(message = "is required")
    @NotEmpty
    private String password;

//    @NotNull(message = "is required")
//    @NotEmpty
    private String matchingPassword;

    private Collection<Role> roles;


}
