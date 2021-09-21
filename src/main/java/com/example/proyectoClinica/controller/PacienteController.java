package com.example.proyectoClinica.controller;

import com.example.proyectoClinica.entities.Odontologo;
import com.example.proyectoClinica.entities.Paciente;
import com.example.proyectoClinica.services.OdontologoService;
import com.example.proyectoClinica.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> getAll(){

        return ResponseEntity.ok(pacienteService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getById(@PathVariable Long id){
        ResponseEntity<Paciente> response = ResponseEntity.ok(pacienteService.getById(id));
        return response;
    }

    @PostMapping
    public ResponseEntity<String> postPaciente(@RequestBody Paciente paciente){

        ResponseEntity<String> response = ResponseEntity.ok("El paciente "+pacienteService.postPaciente(paciente).getNombre()+" fue creado");
        if (response != null){
            return response;
        }else{
            return null;
        }
    }
    @PutMapping
    public ResponseEntity<Paciente> putOdontologo(@RequestParam Paciente paciente){
        ResponseEntity<Paciente> response = ResponseEntity.ok(pacienteService.updatePaciente(paciente));
        return response;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable Long id){
        pacienteService.delete(id);
        return ResponseEntity.ok("Odontologo con id: "+id+" Fue eliminado");
    }
}
