package com.example.proyectoClinica;

import com.example.proyectoClinica.Model.OdontologoDTO;
import com.example.proyectoClinica.entities.Odontologo;
import com.example.proyectoClinica.services.OdontologoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class ProyectoClinicaApplicationTests {
@Autowired
    OdontologoService odontologoService;
    @Test
    void contextLoads() {
    }
    @Test
    void crearUnOdontologo(){

    OdontologoDTO odontologo= new OdontologoDTO();
    odontologo.setApellido("alfredo");
    odontologo.setNombre("armando");
    odontologo.setMatricula(23456);
        Assertions.assertEquals(odontologoService.postOdontologo(odontologo),Odontologo.class);

    }
}
