package com.example.proyectoClinica.repository;

import com.example.proyectoClinica.entities.Paciente;
import com.example.proyectoClinica.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository  extends JpaRepository<Turno,Long> {
}
