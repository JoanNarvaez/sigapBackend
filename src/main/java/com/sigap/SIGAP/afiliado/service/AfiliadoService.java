package com.sigap.SIGAP.afiliado.service;

import com.sigap.SIGAP.afiliado.entity.Afiliado;
import org.springframework.validation.annotation.Validated;

import java.util.List;

public interface AfiliadoService  {
        Afiliado registrar(Afiliado afiliado);
        Afiliado actualizar(Afiliado afiliado);
        Afiliado obtenerPorId(Long id);
        List<Afiliado> ObtenerTodos();

}
