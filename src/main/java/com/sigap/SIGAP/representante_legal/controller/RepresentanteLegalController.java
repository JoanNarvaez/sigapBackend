package com.sigap.SIGAP.representante_legal.controller;

import com.sigap.SIGAP.representante_legal.entity.RepresentanteLegal;
import com.sigap.SIGAP.representante_legal.service.RepresentanteLegalServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor

@RequestMapping("/representante-legal")
public class RepresentanteLegalController {

    private final RepresentanteLegalServiceImpl representanteLegalService;


    @PostMapping("/registrar")
    public ResponseEntity<RepresentanteLegal> registrar(
            @RequestBody RepresentanteLegal representanteLegal) {
        convertirAMayusculas(representanteLegal);
        return new ResponseEntity<>(representanteLegalService.registrar(representanteLegal), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<RepresentanteLegal> actualizar(@PathVariable Long id, @RequestBody RepresentanteLegal representanteLegal) {
        convertirAMayusculas(representanteLegal);
        return new ResponseEntity<>(representanteLegalService.actualizar(id,representanteLegal), HttpStatus.OK);
    }

    @GetMapping("/consultar-por-id/{id}")
    public ResponseEntity<RepresentanteLegal> obtenerPorId(@PathVariable Long id) {

        return new ResponseEntity<>(representanteLegalService.obtenerPorId(id), HttpStatus.OK);
    }

    @GetMapping("/consultar-todos")
    public ResponseEntity<List<RepresentanteLegal>> consultarTodos() {

        return new ResponseEntity<>(representanteLegalService.ObtenerTodos(), HttpStatus.OK);
    }

    private RepresentanteLegal convertirAMayusculas(RepresentanteLegal representanteLegal) {


        if (representanteLegal.getPrimerApeliido() != null) {
            representanteLegal.setPrimerApeliido(representanteLegal.getPrimerApeliido().toUpperCase());
        }
        if (representanteLegal.getSegundoApeliido() != null) {
            representanteLegal.setSegundoApeliido(representanteLegal.getSegundoApeliido().toUpperCase());
        }
        if (representanteLegal.getPrimerNombre() != null) {
            representanteLegal.setPrimerNombre(representanteLegal.getPrimerNombre().toUpperCase());
        }
        if (representanteLegal.getSegundoNombre() != null) {
            representanteLegal.setSegundoNombre(representanteLegal.getSegundoNombre().toUpperCase());
        }
        if (representanteLegal.getCodigoMunicipio() != null) {
            representanteLegal.setCodigoMunicipio(representanteLegal.getCodigoMunicipio().toUpperCase());
        }
        if (representanteLegal.getTelefono() != null) {
            representanteLegal.setTelefono(representanteLegal.getTelefono().toUpperCase());
        }
        if (representanteLegal.getDireccion() != null) {
            representanteLegal.setDireccion(representanteLegal.getDireccion().toUpperCase());
        }
        if (representanteLegal.getEmail() != null) {
            representanteLegal.setEmail(representanteLegal.getEmail().toUpperCase());
        }
        return representanteLegal;
    }

}


