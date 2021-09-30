package com.example.proyectoClinica.services.impl;

import com.example.proyectoClinica.entities.Paciente;
import com.example.proyectoClinica.entities.Turno;
import com.example.proyectoClinica.repository.TurnoRepository;
import com.example.proyectoClinica.services.OdontologoService;
import com.example.proyectoClinica.services.PacienteService;
import com.example.proyectoClinica.services.TurnoService;
import com.fasterxml.jackson.databind.ser.impl.ReadOnlyClassToSerializerMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TurnoServiceImpl implements TurnoService {
  @Autowired
    TurnoRepository turnoRepository;
  @Autowired
    PacienteService pacienteService;
  @Autowired
    OdontologoService odontologoService;
    public TurnoServiceImpl(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public List<Turno> getAll() {
        return turnoRepository.findAll();
    }

    @Override
    public Turno getById(Long id) {
        return turnoRepository.getById(id);
    }

    @Override
    public ResponseEntity<?> postTurno(Turno turno) {

        if (odontologoService.getById(turno.getOdontologo().getId()) != null) {
            if (pacienteService.getById(turno.getPaciente().getId()) != null) {
                 if (this.existeFecha(turno).isEmpty()) {
                turno.setPaciente(pacienteService.getById(turno.getPaciente().getId()));
                turno.setOdontologo(odontologoService.getById(turno.getOdontologo().getId()));
                return ResponseEntity.ok(turnoRepository.save(turno));
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
    public Paciente updateTurno(Paciente paciente) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
    public List<?> existeFecha(Turno turno){
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
