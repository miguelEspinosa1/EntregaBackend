package com.example.proyectoClinica.Model;

import com.example.proyectoClinica.entities.Odontologo;
import com.example.proyectoClinica.entities.Paciente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
public class TurnoDTO {
    private Long id;

      private Odontologo odontologo;

    private Paciente paciente;

    private LocalDate fechaTurno;

    private LocalTime horaTurno;


}
