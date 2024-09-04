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
        validarEmpresa(empresa);
        empresaRepository.findByNumeroNit(empresa.getNumeroNit()).ifPresent(existeEmpresa -> {
            throw new GlobalExcepcion("La empresa con NIT " + existeEmpresa.getNumeroNit() + " ya existe."
                    , HttpStatus.BAD_REQUEST);
        });

        return empresaRepository.save(empresa);

    }

    @Override
    public Empresa actualizar(Empresa empresa) {
        Empresa empresaBd = empresaRepository.findById(empresa.getId()).orElseThrow();
        validarEmpresa(empresa);

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


    private void validarEmpresa(Empresa empresa) {
        if (empresa.getTipoIdentificacion() == null || empresa.getTipoIdentificacion().isEmpty()) {
            throw new GlobalExcepcion("El tipo de identificación no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (empresa.getRazonSocial() == null || empresa.getRazonSocial().isEmpty()) {
            throw new GlobalExcepcion("La razón social no puede estar vacía.", HttpStatus.BAD_REQUEST);
        }
        if (empresa.getNumeroNit() == null) {
            throw new GlobalExcepcion("El número NIT no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (empresa.getDigitoVerificacion() < 0 || empresa.getDigitoVerificacion() > 9) {
            throw new GlobalExcepcion("El dígito de verificación debe ser un número entre 0 y 9.", HttpStatus.BAD_REQUEST);
        }

        if (empresa.getTipoEntidad() < 0) {
            throw new GlobalExcepcion("El tipo de entidad no puede ser negativo.", HttpStatus.BAD_REQUEST);
        }
        if (empresa.getCodigoMunicipio() == null || empresa.getCodigoMunicipio().isEmpty()) {
            throw new GlobalExcepcion("El código del municipio no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (empresa.getActividadEconomica() < 0) {
            throw new GlobalExcepcion("La actividad económica no puede ser negativa.", HttpStatus.BAD_REQUEST);
        }
        if (empresa.getTelefono() == null || empresa.getTelefono().isEmpty()) {
            throw new GlobalExcepcion("El teléfono no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (empresa.getDireccion() == null || empresa.getDireccion().isEmpty()) {
            throw new GlobalExcepcion("La dirección no puede estar vacía.", HttpStatus.BAD_REQUEST);
        }
        if (empresa.getEmail() == null || empresa.getEmail().isEmpty()) {
            throw new GlobalExcepcion("El email no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
    }


}
