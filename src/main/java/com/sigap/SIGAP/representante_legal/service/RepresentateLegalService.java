package com.sigap.SIGAP.representante_legal.service;


import com.sigap.SIGAP.representante_legal.entity.RepresentanteLegal;

import java.util.List;

public interface RepresentateLegalService {
    RepresentanteLegal registrar(RepresentanteLegal  representanteLegal);
    RepresentanteLegal  actualizar(RepresentanteLegal  representanteLegal);
    RepresentanteLegal  obtenerPorId(Long id);
    List<RepresentanteLegal > ObtenerTodos();

}
