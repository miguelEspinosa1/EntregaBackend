package com.example.proyectoClinica.services;


import com.example.proyectoClinica.Model.PacienteDTO;
import com.example.proyectoClinica.entities.Odontologo;
import com.example.proyectoClinica.entities.Paciente;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface PacienteService {
    Collection<PacienteDTO> getAll();

    PacienteDTO getById(Long id);

    PacienteDTO postPaciente(PacienteDTO paciente);

    PacienteDTO updatePaciente(PacienteDTO paciente);

    void delete(Long id);
}
