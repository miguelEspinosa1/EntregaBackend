package com.example.proyectoClinica.services;

import com.example.proyectoClinica.Model.OdontologoDTO;
import com.example.proyectoClinica.entities.Odontologo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public interface OdontologoService {
    Collection<OdontologoDTO> getAll();

    OdontologoDTO getById(Long id);

    OdontologoDTO postOdontologo(OdontologoDTO odontologo);

    OdontologoDTO updateOdontologo( OdontologoDTO odontologo);

   void  delete (Long id);
}
