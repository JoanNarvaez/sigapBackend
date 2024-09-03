package com.sigap.SIGAP.empresa.service;

import com.sigap.SIGAP.empresa.entity.Empresa;
import com.sigap.SIGAP.empresa.repository.EmpresaRepository;
import com.sigap.SIGAP.excepciones.GlobalExcepcion;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

//anotaciones
@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {
//inyeccion de dependencia
    //variable final e suna constante tiene que estar creadas
    private final EmpresaRepository empresaRepository;

    @Override
    public Empresa registrar(Empresa empresa) {

        empresaRepository.findByNumeroNit(empresa.getNumeroNit()).ifPresent(existeEmpresa -> {
            throw new GlobalExcepcion("La empresa con NIT " + existeEmpresa.getNumeroNit() + " ya existe."
                    , HttpStatus.BAD_REQUEST);
        });

        return empresaRepository.save(empresa);

    }

    @Override
    public Empresa actualizar(Empresa empresa) {
        Empresa empresaBd = empresaRepository.findById(empresa.getId()).orElseThrow();

        empresaBd.setEmail(empresa.getEmail());
        empresaBd.setDireccion(empresa.getDireccion());
        empresaBd.setTelefono(empresa.getTelefono());
        empresaBd.setNumeroNit(empresa.getNumeroNit());
        empresaBd.setRazonSocial(empresa.getRazonSocial());
        empresaBd.setCodigoMunicipio(empresa.getCodigoMunicipio());
        empresaBd.setActividadEconomica(empresa.getActividadEconomica());
        empresaBd.setDigitoVerificacion(empresa.getDigitoVerificacion());

        return empresaRepository.save(empresaBd);

    }

    @Override
    public Empresa obtenerPorId(Long id) {
        return empresaRepository.findById(id).orElseThrow(
                () -> new GlobalExcepcion("Empresa no encontrada"
                        , HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Empresa> ObtenerTodos() {
        return empresaRepository.findAll();
    }

}
