package com.example.proyectoClinica.Login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/entrar")
    public String homes(){
        return "<h1>Welcome<h1>";
    }

    @GetMapping("/entrar/user")
    public String casa(){
        return "<h1>Welcome user<h1>";
    }

    @GetMapping("/entrar/admin")
    public String admin(){
        return "<h1>Welcome admin<h1>";
    }
}
