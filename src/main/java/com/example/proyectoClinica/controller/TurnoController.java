package com.example.proyectoClinica.controller;

import com.example.proyectoClinica.Model.TurnoDTO;
import com.example.proyectoClinica.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    TurnoService turnoService;
    @GetMapping
    public ResponseEntity<?> getAll(){

        return ResponseEntity.ok(turnoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        ResponseEntity<TurnoDTO> response = ResponseEntity.ok(turnoService.getById(id));
        return response;
    }

    @PostMapping
    public ResponseEntity<?> postTurno(@RequestBody TurnoDTO turno){
      ResponseEntity<?> turnoDTO= turnoService.postTurno(turno);
  return turnoDTO;

    }
    @PutMapping
    public ResponseEntity<?> putTurno(@RequestParam TurnoDTO turno){
        turnoService.updateTurno(turno);
        return ResponseEntity.ok("el turno ha sido actualizado");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOdontologo(@PathVariable Long id){
        turnoService.delete(id);
        return ResponseEntity.ok("Odontologo con id: "+id+" Fue eliminado");
    }

}
