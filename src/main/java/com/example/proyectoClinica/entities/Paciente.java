package com.example.proyectoClinica.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="pacientes")
public class Paciente {

    @Id
    @SequenceGenerator(name = "domicilio_sequence", sequenceName = "domicilio_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    private Long id;

    private String nombre;
    private String apellido;
    private String dni;

    private String fechaIngreso;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id")
   private Domicilio domicilio;


    public Paciente() {
    }
    public Paciente(String nombre, String apellido, String dni, String fechaIngreso, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
       this.domicilio = domicilio;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

   public Domicilio getDomicilio() {
      return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
       this.domicilio = domicilio;
    }
}
