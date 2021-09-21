package com.example.proyectoClinica.services;

import com.example.proyectoClinica.entities.Odontologo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OdontologoService {
    List<Odontologo> getAll();

    Odontologo getById(Long id);

    Odontologo postOdontologo(Odontologo odontologo);

    Odontologo updateOdontologo( Odontologo odontologo);

   void  delete (Long id);
}
