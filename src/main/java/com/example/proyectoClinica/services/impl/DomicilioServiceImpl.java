package com.example.proyectoClinica.services.impl;

import com.example.proyectoClinica.entities.Domicilio;
import com.example.proyectoClinica.entities.Odontologo;
import com.example.proyectoClinica.entities.Paciente;
import com.example.proyectoClinica.repository.DomicilioRepository;
import com.example.proyectoClinica.services.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioServiceImpl implements DomicilioService {

    @Autowired
    DomicilioRepository domicilioRepository;

    public DomicilioServiceImpl(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    @Override
    public Domicilio postDomicilio(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }

    @Override
    public Domicilio getById(Long id) {
        return domicilioRepository.getById(id);
    }

    @Override
    public Domicilio updateDomicilio(Domicilio domicilio) {
       if(domicilioRepository.getById(domicilio.getId())!=null){
        return domicilioRepository.save(domicilio);
       }
        return null;
    }

    @Override
    public void delete(Long id) {
        domicilioRepository.deleteById(id);
    }


}
