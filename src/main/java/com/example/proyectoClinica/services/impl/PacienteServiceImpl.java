package com.example.proyectoClinica.services.impl;

import com.example.proyectoClinica.entities.Paciente;
import com.example.proyectoClinica.repository.PacienteRepository;
import com.example.proyectoClinica.services.DomicilioService;
import com.example.proyectoClinica.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    DomicilioService domicilioService;


    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public List<Paciente> getAll() {
    
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente getById(Long id) {
        return pacienteRepository.getById(id);
    }

    @Override
    public Paciente postPaciente(Paciente paciente) {
        paciente.setFechaIngreso(LocalDate.now());
       domicilioService.postDomicilio(paciente.getDomicilio());
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente updatePaciente(Paciente paciente) {
        if( pacienteRepository.getById(paciente.getId())!=null) {
       //     domicilioService.updateDomicilio(paciente.getDomicilio());


            return    pacienteRepository.save(paciente);
        }else {


            return null;
        } }

    @Override
    public void delete(Long id) {
      //  domicilioService.delete(pacienteRepository.getById(id).getDomicilio().getId());
        pacienteRepository.deleteById(id);
;
    }
}
