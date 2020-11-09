package ru.cbdd.fvf.entitys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends AbstractEntity{

    private String username;

    private String password;

    private List<Role> roles;



}