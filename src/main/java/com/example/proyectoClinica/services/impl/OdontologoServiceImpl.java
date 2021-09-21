package com.example.proyectoClinica.services.impl;

import com.example.proyectoClinica.entities.Odontologo;
import com.example.proyectoClinica.repository.OdontologoRepository;
import com.example.proyectoClinica.services.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoServiceImpl implements OdontologoService {

   @Autowired
    OdontologoRepository odontologoRepository;

    public OdontologoServiceImpl(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public List<Odontologo> getAll() {
        return odontologoRepository.findAll();
    }

    @Override
    public Odontologo postOdontologo(Odontologo odontologo){return (Odontologo) odontologoRepository.save(odontologo); }

    @Override
    public Odontologo updateOdontologo(Odontologo odontologo) {
            if(odontologoRepository.getById(odontologo.getId()) != null){
                return odontologoRepository.save(odontologo);
            }
        return null;
    }

    @Override
    public void delete(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Odontologo getById(Long id ) {
        return (Odontologo) odontologoRepository.getById(id);
    }
}
