package com.esg.esgProject.firebase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class VueIndexController {
    @GetMapping("vue")
    public String hello() {return "index";}
}
