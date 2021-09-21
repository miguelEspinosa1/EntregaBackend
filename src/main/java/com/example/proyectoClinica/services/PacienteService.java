package com.example.proyectoClinica.services;


import com.example.proyectoClinica.entities.Odontologo;
import com.example.proyectoClinica.entities.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PacienteService {
    List <Paciente> getAll();

    Paciente getById(Long id);

    Paciente postPaciente(Paciente paciente);

    Paciente updatePaciente(Paciente paciente);

    void delete(Long id);
}
