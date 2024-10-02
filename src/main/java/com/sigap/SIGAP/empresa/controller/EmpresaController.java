package com.sigap.SIGAP.empresa.controller;

import com.sigap.SIGAP.empresa.entity.Empresa;
import com.sigap.SIGAP.empresa.service.EmpresaServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/empresa")
@Slf4j
public class EmpresaController {

    private final EmpresaServiceImpl empresaService;


    @PostMapping("/registrar")
    public ResponseEntity<Empresa> registrar(
            @RequestBody Empresa empresa) {
        convertirAMayusculas(empresa);
        return new ResponseEntity<>(empresaService.registrar(empresa), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Empresa> actualizar(@PathVariable Long id, @RequestBody Empresa empresa) {
        convertirAMayusculas(empresa);
        return new ResponseEntity<>(empresaService.actualizar(id, empresa), HttpStatus.OK);
    }

    @GetMapping("/consultar-por-id/{id}")
    public ResponseEntity<Empresa> obtenerPorId(@PathVariable Long id) {

        return new ResponseEntity<>(empresaService.obtenerPorId(id), HttpStatus.OK);
    }

    @GetMapping("/consultar-todos")
    public ResponseEntity<List<Empresa>> consultarTodos() {

        return new ResponseEntity<>(empresaService.ObtenerTodos(), HttpStatus.OK);
    }

    private Empresa convertirAMayusculas(Empresa empresa) {

        if (empresa.getRazonSocial() != null) {
            empresa.setRazonSocial(empresa.getRazonSocial().toUpperCase());
        }
        if (empresa.getCodigoMunicipio() != null) {
            empresa.setCodigoMunicipio(empresa.getCodigoMunicipio().toUpperCase());
        }
        if (empresa.getTelefono() != null) {
            empresa.setTelefono(empresa.getTelefono().toUpperCase());
        }
        if (empresa.getDireccion() != null) {
            empresa.setDireccion(empresa.getDireccion().toUpperCase());
        }
        if (empresa.getEmail() != null) {
            empresa.setEmail(empresa.getEmail().toUpperCase());
        }
        return empresa;
    }

}
