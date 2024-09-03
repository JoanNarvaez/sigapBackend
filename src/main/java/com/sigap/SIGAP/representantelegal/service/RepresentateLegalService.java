package com.sigap.SIGAP.representantelegal.service;


import com.sigap.SIGAP.representantelegal.entity.RepresentanteLegal;

import java.util.List;

public interface RepresentateLegalService {
    RepresentanteLegal registrar(RepresentanteLegal  representanteLegal);
    RepresentanteLegal  actualizar(RepresentanteLegal  representanteLegal);
    RepresentanteLegal  obtenerPorId(Long id);
    List<RepresentanteLegal > ObtenerTodos();

}
