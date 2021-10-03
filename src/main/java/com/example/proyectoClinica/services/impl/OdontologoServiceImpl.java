package com.example.proyectoClinica.services.impl;

import com.example.proyectoClinica.Model.OdontologoDTO;
import com.example.proyectoClinica.entities.Odontologo;
import com.example.proyectoClinica.repository.OdontologoRepository;
import com.example.proyectoClinica.services.OdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class OdontologoServiceImpl implements OdontologoService {

    @Autowired
    OdontologoRepository odontologoRepository;
    @Autowired
    ObjectMapper objectMapper;

    public OdontologoServiceImpl(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public Collection<OdontologoDTO> getAll() {
        List<Odontologo> odontologos= odontologoRepository.findAll();
        Set<OdontologoDTO> odontologoDTOS= new HashSet<>();
        for (Odontologo odontologo: odontologos){
            odontologoDTOS.add(objectMapper.convertValue(odontologo,OdontologoDTO.class));
        }
        return odontologoDTOS;
    }

    @Override
    public OdontologoDTO postOdontologo(OdontologoDTO odontologo){
        Odontologo odontologo1= objectMapper.convertValue(odontologo,Odontologo.class);

        return objectMapper.convertValue(odontologoRepository.save(odontologo1),OdontologoDTO.class);
    }

    @Override
    public OdontologoDTO updateOdontologo(OdontologoDTO odontologo) {
            if(odontologoRepository.findById(odontologo.getId()).isPresent()){
               Odontologo odontologo1= odontologoRepository.save(objectMapper.convertValue(odontologo, Odontologo.class));
                return odontologo;
            }
        return null;
    }

    @Override
    public void delete(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public OdontologoDTO getById(Long id ) {
        OdontologoDTO odontologoDTO=null;
        Optional<Odontologo> odontologo= odontologoRepository.findById(id);
        if (odontologo.isPresent()){
            odontologoDTO= objectMapper.convertValue(odontologo,OdontologoDTO.class);
        }
        return odontologoDTO;
    }
}
