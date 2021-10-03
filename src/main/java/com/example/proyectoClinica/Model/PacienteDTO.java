package com.example.proyectoClinica.Model;

import com.example.proyectoClinica.entities.Domicilio;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter @Getter
public class PacienteDTO {
    private Long id;

    private String nombre;
    private String apellido;
    private String dni;

    private LocalDate fechaIngreso;

    private Domicilio domicilio;

}
