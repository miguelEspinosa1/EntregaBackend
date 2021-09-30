package com.example.proyectoClinica.entities;




import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="turnos")
public class Turno {
    @Id
    @GeneratedValue(generator = "secuenciaDeTurno" , strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "secuenciaDeTurno", sequenceName = "BD_SECUENCIA_TURNO", allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id")
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

    public Long getId() {
        return id;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(LocalDate fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public LocalTime getHoraTurno() {
        return horaTurno;
    }

    public void setHoraTurno(LocalTime horaTurno) {
        this.horaTurno = horaTurno;
    }
}
