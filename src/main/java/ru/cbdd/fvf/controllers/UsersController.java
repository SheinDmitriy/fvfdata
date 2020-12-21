package ru.cbdd.fvf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.cbdd.fvf.entitys.ComplexDB;
import ru.cbdd.fvf.entitys.SystemUser;
import ru.cbdd.fvf.service.ComplexService;
import ru.cbdd.fvf.service.RoleService;
import ru.cbdd.fvf.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;
    private final RoleService roleService;
    private final ComplexService complexService;

    @Autowired
    public UsersController(UserService userService, RoleService roleService, ComplexService complexService) {
        this.userService = userService;
        this.roleService = roleService;
        this.complexService = complexService;
    }

    @GetMapping
    public String userPage(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/{id}")
    public String editUser(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
//        model.addAttribute("roles", roleService.findByUserId(id));
        return "user_page";
    }

    @GetMapping("/form")
    public String formUser(Model model) {
        model.addAttribute("user", new SystemUser());
        model.addAttribute("roles", roleService.findAll());
        return "user_form";
    }

    @PostMapping("/form")
    public String newUser(@Valid SystemUser systemUser, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user_form";
        }
        if (!systemUser.getPassword().equals(systemUser.getMatchingPassword())) {
            model.addAttribute("error", "Password not matching");
            model.addAttribute("user", systemUser);
            model.addAttribute("roles", roleService.findAll());
            return "user_form";
        }
        userService.save(systemUser);
        return "redirect:/users";
    }
}
