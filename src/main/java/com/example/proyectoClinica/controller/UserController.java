package com.example.proyectoClinica.controller;

import com.example.proyectoClinica.entities.User.AppUser;

import com.example.proyectoClinica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository= userRepository;
    }


    @GetMapping("/create")
    public String homes(@RequestBody AppUser appUser){
        String password= passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(password);
        userRepository.save(appUser);

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
