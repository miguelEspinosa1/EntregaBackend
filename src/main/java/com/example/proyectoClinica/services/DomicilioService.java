package com.example.proyectoClinica.services;

import com.example.proyectoClinica.entities.Domicilio;
import com.example.proyectoClinica.entities.Odontologo;
import com.example.proyectoClinica.entities.Paciente;

public interface DomicilioService {
    Domicilio postDomicilio(Domicilio domicilio);
    Domicilio getById(Long id);
    Domicilio updateDomicilio(Domicilio domicilio);
    void delete(Long id);

}
