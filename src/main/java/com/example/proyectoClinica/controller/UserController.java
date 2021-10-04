package com.example.proyectoClinica.controller;

import com.example.proyectoClinica.entities.User.AppUser;

import com.example.proyectoClinica.services.impl.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    AppUserService appUserService;

    @GetMapping("/create")
    public String homes(@RequestBody AppUser appUser){

        appUserService.create(appUser);

        return "Usuario Creado";
    }


   }
