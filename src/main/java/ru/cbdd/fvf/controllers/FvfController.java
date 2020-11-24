package ru.cbdd.fvf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.cbdd.fvf.service.ComplexService;

@Controller
@RequestMapping("/fvf")
public class FvfController {

    private ComplexService complexService;

    @Autowired
    public void setComplexService(ComplexService complexService) {
        this.complexService = complexService;
    }

    @GetMapping
    public String fvfPage(Model model) {
        model.addAttribute("complex", complexService.findAll());
        return "fvf";
    }
}
