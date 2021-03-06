package com.example.proyectoClinica.controller;

import com.example.proyectoClinica.Model.PacienteDTO;
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
    public ResponseEntity<?> getAll(){

        return ResponseEntity.ok(pacienteService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        ResponseEntity<PacienteDTO> response = ResponseEntity.ok(pacienteService.getById(id));
        return response;
    }

    @PostMapping
    public ResponseEntity<String> postPaciente(@RequestBody PacienteDTO paciente){
    PacienteDTO pacientel= pacienteService.postPaciente(paciente);
         if (pacientel != null){
            return ResponseEntity.ok("El paciente "+pacientel.getNombre()+" fue creado");
        }else{
            return ResponseEntity.badRequest().body("No se pudo crear el paciente");
        }
    }
    @PutMapping
    public ResponseEntity<?> putPaciente(@RequestParam PacienteDTO paciente){
        ResponseEntity<PacienteDTO> response = ResponseEntity.ok(pacienteService.updatePaciente(paciente));
        return response;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable Long id){
        pacienteService.delete(id);
        return ResponseEntity.ok("Odontologo con id: "+id+" Fue eliminado");
    }
}
