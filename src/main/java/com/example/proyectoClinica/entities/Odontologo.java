package com.example.proyectoClinica.entities;

import javax.persistence.*;


@Entity
@Table(name="Odontologos")

public class Odontologo {

    @Id
    @SequenceGenerator(name="odontologo_sequence",sequenceName = "odontologo_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence_generator")
    private Long id;

    private String nombre;
    private String apellido;
    private Integer matricula;

    public Odontologo() {

    }

    public Odontologo(String nombre, String apellido, Integer matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
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

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }
}
