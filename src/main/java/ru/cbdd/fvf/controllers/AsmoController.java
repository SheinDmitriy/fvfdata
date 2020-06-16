package ru.cbdd.fvf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/asmo")
public class AsmoController {

    @Autowired
    public AsmoController() {
    }

    @GetMapping
    public String fvfPage() {
        return "asmo";
    }
}
