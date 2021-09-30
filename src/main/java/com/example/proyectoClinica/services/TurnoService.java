package com.example.proyectoClinica.services;

import com.example.proyectoClinica.entities.Paciente;
import com.example.proyectoClinica.entities.Turno;
import org.apache.catalina.LifecycleState;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TurnoService {
    List<Turno> getAll();

    Turno getById(Long id);

    ResponseEntity<?> postTurno(Turno turno);
    Paciente updateTurno(Paciente paciente);

    void delete(Long id);
}