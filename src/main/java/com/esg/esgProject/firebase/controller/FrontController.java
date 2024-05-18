package com.esg.esgProject.firebase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FrontController {
    @GetMapping("/test")
    public String test() {return "Springboot와 Vue.js 연동 완료!";}
}
