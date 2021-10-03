package com.example.proyectoClinica.controller;

import com.example.proyectoClinica.Model.OdontologoDTO;
import com.example.proyectoClinica.entities.Odontologo;
import com.example.proyectoClinica.services.OdontologoService;
import com.example.proyectoClinica.services.impl.OdontologoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.openmbean.CompositeData;
import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
     @Autowired
    OdontologoService odontologoService;

    @GetMapping
    public ResponseEntity<?> getAll(){

        return ResponseEntity.ok(odontologoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
            ResponseEntity<OdontologoDTO> response = ResponseEntity.ok(odontologoService.getById(id));
            return response;
    }

    @PostMapping
    public ResponseEntity<String> postOdontologo(@RequestBody OdontologoDTO odontologo){

        ResponseEntity<String> response = ResponseEntity.ok("El odontologo "+odontologoService.postOdontologo(odontologo).getNombre()+" fue creado");
            return response;
         }
    @PutMapping
    public ResponseEntity<?> putOdontologo(@RequestParam OdontologoDTO odontologo){
        ResponseEntity<OdontologoDTO> response = ResponseEntity.ok(odontologoService.updateOdontologo(odontologo));
        return response;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOdontologo(@PathVariable Long id){
       odontologoService.delete(id);
       return ResponseEntity.ok("Odontologo con id: "+id+" Fue eliminado");
    }
}
