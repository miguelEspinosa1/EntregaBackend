package com.example.proyectoClinica.services.impl;

import com.example.proyectoClinica.entities.User.AppUser;
import com.example.proyectoClinica.entities.User.UserRoles;
import com.example.proyectoClinica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService  implements UserDetailsService, ApplicationRunner {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    private  final UserRepository userRepository;
    @Autowired
    public AppUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User email not found"));
    }
    public String create(AppUser appUser){

        String password= passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(password);
        userRepository.save(appUser);

        return "<h1>Welcome<h1>";
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String password = passwordEncoder.encode("password");
        userRepository.save(new AppUser("Mateo","mateo123","mateo@paez.com",password, UserRoles.ADMIN));
    }
}
