package ru.cbdd.fvf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    public IndexController() {
    }

    @GetMapping
    public String mainPage() {
        return "index";
    }

    @GetMapping("/fvf")
    public String showFvf(Model model){
        return "fvf";
    }

    @GetMapping("/video")
    public String showVideo(Model model){
        return "video";
    }

    @GetMapping("/apvgk")
    public String showApvgk(Model model){
        return "apvgk";
    }

    @GetMapping("/asmo")
    public String showAsmo(Model model){
        return "asmo";
    }
}
