package com.example.proyectoClinica.entities;




import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="turnos")
@Getter
@Setter
public class Turno {
    @Id
    @GeneratedValue(generator = "secuenciaDeTurno" , strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "secuenciaDeTurno", sequenceName = "BD_SECUENCIA_TURNO", allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "odontologo_id",nullable = false)
    private Odontologo odontologo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id",nullable = false)
    private Paciente paciente;

    private LocalDate fechaTurno;

    private LocalTime horaTurno;

    public Turno(Odontologo odontologo, Paciente paciente, String fechaTurno, String horaTurno) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        LocalDate fecha= LocalDate.parse(fechaTurno);
        this.fechaTurno=fecha;
        LocalTime hora= LocalTime.parse(horaTurno);
        this.horaTurno= hora;
    }

    public Turno() {
    }


}
