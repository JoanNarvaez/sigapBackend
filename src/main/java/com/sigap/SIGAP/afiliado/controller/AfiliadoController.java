package com.sigap.SIGAP.afiliado.controller;

import com.sigap.SIGAP.afiliado.entity.Afiliado;
import com.sigap.SIGAP.afiliado.service.AfiliadoServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/afiliado")
@Slf4j
@RestController
public class AfiliadoController {

    private final AfiliadoServiceImpl afiliadoService;

    @PostMapping("/registrar")
    public ResponseEntity<Afiliado> registrar(
            @RequestBody Afiliado afiliado) {
        convertirAMayusculas(afiliado);
        return new ResponseEntity<>(afiliadoService.registrar(afiliado), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Afiliado> actualizar(@PathVariable Long id, @RequestBody Afiliado afiliado) {
        convertirAMayusculas(afiliado);
        return new ResponseEntity<>(afiliadoService.actualizar(id, afiliado), HttpStatus.OK);
    }

    @GetMapping("/consultar-por-id/{id}")
    public ResponseEntity<Afiliado> obtenerPorId(@PathVariable Long id) {

        return new ResponseEntity<>(afiliadoService.obtenerPorId(id), HttpStatus.OK);
    }

    @GetMapping("/consultar-todos")
    public ResponseEntity<List<Afiliado>> consultarTodos() {
        return new ResponseEntity<>(afiliadoService.ObtenerTodos(), HttpStatus.OK);


    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {

        return new ResponseEntity<>(afiliadoService.eliminar(id), HttpStatus.OK);
    }

    private Afiliado convertirAMayusculas(Afiliado afiliado) {


        if (afiliado.getPrimerApeliido() != null) {
            afiliado.setPrimerApeliido(afiliado.getPrimerApeliido().toUpperCase());
        }
        if (afiliado.getSegundoApeliido() != null) {
            afiliado.setSegundoApeliido(afiliado.getSegundoApeliido().toUpperCase());
        }
        if (afiliado.getPrimerNombre() != null) {
            afiliado.setPrimerNombre(afiliado.getPrimerNombre().toUpperCase());
        }
        if (afiliado.getSegundoNombre() != null) {
            afiliado.setSegundoNombre(afiliado.getSegundoNombre().toUpperCase());
        }

        if (afiliado.getDireccion() != null) {
            afiliado.setDireccion(afiliado.getDireccion().toUpperCase());
        }
        if (afiliado.getEmail() != null) {
            afiliado.setEmail(afiliado.getEmail().toUpperCase());
        }
        return afiliado;
    }

}
