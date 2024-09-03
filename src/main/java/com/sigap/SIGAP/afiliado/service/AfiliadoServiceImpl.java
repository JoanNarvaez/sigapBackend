package com.sigap.SIGAP.afiliado.service;


import com.sigap.SIGAP.afiliado.entity.Afiliado;
import com.sigap.SIGAP.afiliado.repository.AfiliadoRepository;
import com.sigap.SIGAP.excepciones.GlobalExcepcion;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AfiliadoServiceImpl implements AfiliadoService{

    private final AfiliadoRepository afiliadoRepository;


    @Override
    public Afiliado registrar(Afiliado afiliado) {
        afiliadoRepository.findByNumeroIdentificacion(afiliado.getNumeroIdentificacion()).ifPresent(existeNumIdentificacion -> {
            throw new GlobalExcepcion("El Numero de Identificacion " + existeNumIdentificacion.getNumeroIdentificacion() + " ya existe."
                    , HttpStatus.BAD_REQUEST);
        });

        return afiliadoRepository.save(afiliado);


    }

    @Override
    public Afiliado actualizar(Afiliado afiliado) {
        Afiliado afiliadoBd = afiliadoRepository.findById(afiliado.getId()).orElseThrow();

        afiliadoBd.setPrimerNombre(afiliado.getPrimerNombre());
        afiliadoBd.setSegundoNombre(afiliado.getSegundoNombre());
        afiliadoBd.setTipoDocumento(afiliado.getTipoDocumento());
        afiliadoBd.setNumeroIdentificacion(afiliado.getNumeroIdentificacion());
        afiliadoBd.setPrimerApeliido(afiliado.getPrimerApeliido());
        afiliadoBd.setSegundoApeliido(afiliado.getSegundoApeliido());
        afiliadoBd.setFechaNacimiento(afiliado.getFechaNacimiento());
        afiliadoBd.setGenero(afiliado.getGenero());
        afiliadoBd.setCodigoMunicipio(afiliado.getCodigoMunicipio());
        afiliadoBd.setIndicador(afiliado.getIndicador());
        afiliadoBd.setTelefono(afiliado.getTelefono());
        afiliadoBd.setDireccion(afiliado.getDireccion());
        afiliadoBd.setEmail(afiliado.getEmail());
        afiliadoBd.setFechaIngreso(afiliado.getFechaIngreso());
        afiliadoBd.setFechaRetiro(afiliado.getFechaRetiro());


        return afiliadoRepository.save(afiliadoBd);
    }

    @Override
    public Afiliado obtenerPorId(Long id) {
        return afiliadoRepository.findById(id).orElseThrow(
                () -> new GlobalExcepcion("Afiliado no encontrado"
                        , HttpStatus.NOT_FOUND));
    }

    @Override
        public List<Afiliado> ObtenerTodos() { return afiliadoRepository.findAll();
        }

}
