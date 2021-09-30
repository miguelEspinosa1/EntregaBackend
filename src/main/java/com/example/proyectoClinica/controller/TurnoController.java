package com.example.proyectoClinica.controller;

import com.example.proyectoClinica.entities.Odontologo;
import com.example.proyectoClinica.entities.Paciente;
import com.example.proyectoClinica.entities.Turno;
import com.example.proyectoClinica.services.PacienteService;
import com.example.proyectoClinica.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    TurnoService turnoService;
    @GetMapping
    public ResponseEntity<List<Turno>> getAll(){

        return ResponseEntity.ok(turnoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> getById(@PathVariable Long id){
        ResponseEntity<Turno> response = ResponseEntity.ok(turnoService.getById(id));
        return response;
    }

    @PostMapping
    public ResponseEntity<?> postTurno(@RequestBody Turno turno){
       return turnoService.postTurno(turno);

    }
    @PatchMapping
    public ResponseEntity<?> putTurno(@RequestParam Turno turno){
        //ResponseEntity<Odontologo> response = ResponseEntity.ok(odontologoService.updateOdontologo(odontologo));
        return null;//response;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOdontologo(@PathVariable Long id){
       // odontologoService.delete(id);
        return ResponseEntity.ok("Odontologo con id: "+id+" Fue eliminado");
    }

}
