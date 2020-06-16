package ru.cbdd.fvf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/apvgk")
public class ApvgkController {

    @Autowired
    public ApvgkController() {
    }

    @GetMapping
    public String apvgkPage() {
        return "apvgk";
    }
}
