package com.example.proyectoClinica.services;

import com.example.proyectoClinica.Model.TurnoDTO;
import com.example.proyectoClinica.entities.Paciente;
import com.example.proyectoClinica.entities.Turno;
import org.apache.catalina.LifecycleState;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public interface TurnoService {
    Collection<TurnoDTO> getAll();

    TurnoDTO getById(Long id);

    ResponseEntity<?> postTurno(TurnoDTO turno);

    TurnoDTO updateTurno(TurnoDTO turno);

    void delete(Long id);
}