package com.sigap.SIGAP.afiliado.controller;

import com.sigap.SIGAP.afiliado.entity.Afiliado;
import com.sigap.SIGAP.afiliado.service.AfiliadoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/afiliado")
public class AfiliadoController {

    private final AfiliadoServiceImpl afiliadoService;
    @PostMapping("/registrar")
    public ResponseEntity<Afiliado> registrar(
            @RequestBody Afiliado afiliado) {

        return new ResponseEntity<>(afiliadoService.registrar(afiliado), HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Afiliado> actualizar(@RequestBody Afiliado afiliado) {
        return new ResponseEntity<>(afiliadoService.actualizar(afiliado), HttpStatus.OK);
    }

    @GetMapping("/consultar-por-id/{id}")
    public ResponseEntity<Afiliado> obtenerPorId(@PathVariable Long id) {

        return new ResponseEntity<>(afiliadoService.obtenerPorId(id), HttpStatus.OK);
    }

    @GetMapping("/consultar-todos")
    public ResponseEntity<List<Afiliado>> consultarTodos() {

        return new ResponseEntity<>(afiliadoService.ObtenerTodos(), HttpStatus.OK);
    }

}
