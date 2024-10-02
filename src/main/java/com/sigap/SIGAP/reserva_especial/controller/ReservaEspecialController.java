package com.sigap.SIGAP.reserva_especial.controller;


import com.sigap.SIGAP.reserva_especial.entity.ReservaEspecial;
import com.sigap.SIGAP.reserva_especial.service.ReservaEspecialServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor

@RequestMapping("/reserva-especial")
public class ReservaEspecialController {

    private final ReservaEspecialServiceImpl reservaEspecialService;


    @PostMapping("/registrar")
    public ResponseEntity<ReservaEspecial> registrar(
            @RequestBody ReservaEspecial reservaEspecial) {
        convertirAMayusculas(reservaEspecial);
        return new ResponseEntity<>(reservaEspecialService.registrar(reservaEspecial), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ReservaEspecial> actualizar(@PathVariable Long id, @RequestBody ReservaEspecial reservaEspecial) {
        convertirAMayusculas(reservaEspecial);
        return new ResponseEntity<>(reservaEspecialService.actualizar(id,reservaEspecial), HttpStatus.OK);
    }

    @GetMapping("/consultar-por-id/{id}")
    public ResponseEntity<ReservaEspecial> obtenerPorId(@PathVariable Long id) {

        return new ResponseEntity<>(reservaEspecialService.obtenerPorId(id), HttpStatus.OK);
    }

    @GetMapping("/consultar-todos")
    public ResponseEntity<List<ReservaEspecial>> consultarTodos() {

        return new ResponseEntity<>(reservaEspecialService.ObtenerTodos(), HttpStatus.OK);
    }
    private ReservaEspecial convertirAMayusculas(ReservaEspecial reservaEspecial) {

        if (reservaEspecial.getRazonSocial() != null) {
            reservaEspecial.setRazonSocial(reservaEspecial.getRazonSocial().toUpperCase());
        }
        if (reservaEspecial.getPrimerApeliido() != null) {
            reservaEspecial.setPrimerApeliido(reservaEspecial.getPrimerApeliido().toUpperCase());
        }
        if (reservaEspecial.getSegundoApeliido() != null) {
            reservaEspecial.setSegundoApeliido(reservaEspecial.getSegundoApeliido().toUpperCase());
        }
        if (reservaEspecial.getPrimerNombre() != null) {
            reservaEspecial.setPrimerNombre(reservaEspecial.getPrimerNombre().toUpperCase());
        }
        if (reservaEspecial.getSegundoNombre() != null) {
            reservaEspecial.setSegundoNombre(reservaEspecial.getSegundoNombre().toUpperCase());
        }
        if (reservaEspecial.getTarjetaProfecional() != null) {
            reservaEspecial.setTarjetaProfecional(reservaEspecial.getTarjetaProfecional().toUpperCase());
        }
        if (reservaEspecial.getCodigoMunicipio() != null) {
            reservaEspecial.setCodigoMunicipio(reservaEspecial.getCodigoMunicipio().toUpperCase());
        }
        if (reservaEspecial.getTelefono() != null) {
            reservaEspecial.setTelefono(reservaEspecial.getTelefono().toUpperCase());
        }
        if (reservaEspecial.getDireccion() != null) {
            reservaEspecial.setDireccion(reservaEspecial.getDireccion().toUpperCase());
        }
        if (reservaEspecial.getEmail() != null) {
            reservaEspecial.setEmail(reservaEspecial.getEmail().toUpperCase());
        }
        return reservaEspecial;
    }
}


