package com.example.proyectoClinica.services.impl;

import com.example.proyectoClinica.Model.PacienteDTO;
import com.example.proyectoClinica.entities.Paciente;
import com.example.proyectoClinica.repository.PacienteRepository;
import com.example.proyectoClinica.services.DomicilioService;
import com.example.proyectoClinica.services.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    DomicilioService domicilioService;
    @Autowired
    ObjectMapper objectMapper;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Collection<PacienteDTO> getAll() {
       List <Paciente> pacientes= pacienteRepository.findAll();
       Set<PacienteDTO> pacienteDTOSet= new HashSet<>();
       for( Paciente paciente: pacientes){
           pacienteDTOSet.add(objectMapper.convertValue(paciente,PacienteDTO.class));
       }
        return pacienteDTOSet;
    }

    @Override
    public PacienteDTO getById(Long id) {
    PacienteDTO pacienteDTO= null;
    Optional<Paciente> paciente=   pacienteRepository.findById(id);
    if(paciente.isPresent()){
        pacienteDTO= objectMapper.convertValue(paciente,PacienteDTO.class);
    }
        return pacienteDTO;
    }

    @Override
    public PacienteDTO postPaciente(PacienteDTO paciente) {
        Paciente paciente1= objectMapper.convertValue(paciente,Paciente.class);
        paciente1.setFechaIngreso(LocalDate.now());
       domicilioService.postDomicilio(paciente.getDomicilio());
        return objectMapper.convertValue(pacienteRepository.save(paciente1),PacienteDTO.class);
    }

    @Override
    public PacienteDTO updatePaciente(PacienteDTO paciente) {
        if( pacienteRepository.findById(paciente.getId()).isPresent()) {
           domicilioService.updateDomicilio(paciente.getDomicilio());

            Paciente paciente1=  pacienteRepository.save(objectMapper.convertValue(paciente,Paciente.class));
            return paciente;
        }else {


            return null;
        } }

    @Override
    public void delete(Long id) {
        domicilioService.delete(pacienteRepository.getById(id).getDomicilio().getId());
        pacienteRepository.deleteById(id);
;
    }
}
