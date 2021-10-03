package com.example.proyectoClinica.services.impl;

import com.example.proyectoClinica.Model.TurnoDTO;
import com.example.proyectoClinica.entities.Odontologo;
import com.example.proyectoClinica.entities.Paciente;
import com.example.proyectoClinica.entities.Turno;
import com.example.proyectoClinica.repository.TurnoRepository;
import com.example.proyectoClinica.services.OdontologoService;
import com.example.proyectoClinica.services.PacienteService;
import com.example.proyectoClinica.services.TurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.ReadOnlyClassToSerializerMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class TurnoServiceImpl implements TurnoService {
  @Autowired
    TurnoRepository turnoRepository;
  @Autowired
    PacienteService pacienteService;
  @Autowired
    OdontologoService odontologoService;
  @Autowired
    ObjectMapper objectMapper;
    public TurnoServiceImpl(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public Collection<TurnoDTO> getAll() {
        List <Turno> turnos=  turnoRepository.findAll();
        Set<TurnoDTO> turnoDTOS= new HashSet<>();
        for (Turno turno: turnos){
            turnoDTOS.add(objectMapper.convertValue(turno, TurnoDTO.class));
        }

        return turnoDTOS;
    }

    @Override
    public TurnoDTO getById(Long id) {
        TurnoDTO turnoDTO=null;
        Optional<Turno> turno= turnoRepository.findById(id);

        if (turno.isPresent()){
            turnoDTO=objectMapper.convertValue(turno,TurnoDTO.class);
        }

        return turnoDTO;
    }

    @Override
    public ResponseEntity<?> postTurno(TurnoDTO turno) {
        Turno turno1= objectMapper.convertValue(turno,Turno.class);
        if (odontologoService.getById(turno.getOdontologo().getId()) != null) {
            if (pacienteService.getById(turno.getPaciente().getId()) != null) {
                 if (this.existeFecha(turno).isEmpty()) {
                turno1.setPaciente(objectMapper.convertValue(pacienteService.getById(turno.getPaciente().getId()),Paciente.class));
                turno1.setOdontologo(objectMapper.convertValue(odontologoService.getById(turno.getOdontologo().getId()), Odontologo.class));
                return ResponseEntity.ok(turnoRepository.save(turno1));
                     }else{
                     return ResponseEntity.badRequest().body("La fecha ya esta asignada");
                 }
                 } else {  return ResponseEntity.badRequest().body("El paciente no eiste");

                     }
            } else {
            return ResponseEntity.badRequest().body("El odontologo no existe");
            }

        }

    @Override
    public TurnoDTO updateTurno(TurnoDTO turno) {
        return null;
    }

    @Override
    public void delete(Long id) {
    turnoRepository.deleteById(id);
    }
    public List<?> existeFecha(TurnoDTO turno){
        List<Turno> turnos= turnoRepository.findAll();
        List<Turno> turnosMismaFecha= new ArrayList<>();
        if (!turnos.isEmpty()){
        for (Turno t:
             turnos) {
            if (t.getFechaTurno().equals(turno.getFechaTurno())&& t
                    .getHoraTurno().format(DateTimeFormatter.ofPattern("HH")).equals(turno.getHoraTurno().format(DateTimeFormatter.ofPattern("HH")))&& t.getOdontologo().getId().equals(turno.getOdontologo().getId())){
             turnosMismaFecha.add(t);
            }

        }}
        return turnosMismaFecha;
    }

}
