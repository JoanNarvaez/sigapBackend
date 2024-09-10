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

        validarAfiliado(afiliado);


        afiliadoRepository.findByNumeroIdentificacion(afiliado.getNumeroIdentificacion()).ifPresent(existeNumIdentificacion -> {
            throw new GlobalExcepcion("El Numero de Identificacion " + existeNumIdentificacion.getNumeroIdentificacion() + " ya existe."
                    , HttpStatus.BAD_REQUEST);
        });

        return afiliadoRepository.save(afiliado);


    }

    @Override
    public Afiliado actualizar(long id,Afiliado afiliado) {
        Afiliado afiliadoBd = afiliadoRepository.findById(id).orElseThrow();

        validarAfiliado(afiliado);

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

        System.out.println("Afiliado actualizado: " + afiliadoBd);

        return afiliadoRepository.save(afiliadoBd);
    }
   /* public Afiliado actualizar(long id, Afiliado afiliado) {
        // Buscar el afiliado en la base de datos por su ID
        Afiliado afiliadoBd = afiliadoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Afiliado no encontrado con el ID: " + id));

        // Validar los datos del afiliado antes de proceder con la actualización
        validarAfiliado(afiliado);

        // Actualizar los campos del afiliado con los nuevos datos
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

        // Imprimir en la consola que el afiliado ha sido actualizado
        System.out.println("Afiliado actualizado: " + afiliadoBd);

        // Guardar los cambios en la base de datos y retornar el objeto actualizado
        return afiliadoRepository.save(afiliadoBd);
    }*/



    @Override
    public Afiliado obtenerPorId(Long id) {
        return afiliadoRepository.findById(id).orElseThrow(
                () -> new GlobalExcepcion("Afiliado no encontrado"
                        , HttpStatus.NOT_FOUND));
    }

    @Override
        public List<Afiliado> ObtenerTodos() { return afiliadoRepository.findAll();
        }

    private void validarAfiliado(Afiliado afiliado) {
        if (afiliado.getTipoDocumento() == null || afiliado.getTipoDocumento().isEmpty()) {
            throw new GlobalExcepcion("El tipo de documento no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (afiliado.getNumeroIdentificacion() == null) {
            throw new GlobalExcepcion("El número de identificación no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (afiliado.getPrimerApeliido() == null || afiliado.getPrimerApeliido().isEmpty()) {
            throw new GlobalExcepcion("El primer apellido no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        // 'Segundo apellido' puede estar vacío, no se valida.

        if (afiliado.getPrimerNombre() == null || afiliado.getPrimerNombre().isEmpty()) {
            throw new GlobalExcepcion("El primer nombre no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        // 'Segundo nombre' puede estar vacío, no se valida.

        if (afiliado.getFechaNacimiento() == null) {
            throw new GlobalExcepcion("La fecha de nacimiento no puede estar vacía.", HttpStatus.BAD_REQUEST);
        }
        if (afiliado.getGenero() == null || afiliado.getGenero().isEmpty()) {
            throw new GlobalExcepcion("El género no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (afiliado.getCodigoMunicipio() == null || afiliado.getCodigoMunicipio().isEmpty()) {
            throw new GlobalExcepcion("El código del municipio no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (afiliado.getIndicador() == null || afiliado.getIndicador().isEmpty()) {
            throw new GlobalExcepcion("El indicador no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (afiliado.getTelefono() == null || afiliado.getTelefono().isEmpty()) {
            throw new GlobalExcepcion("El teléfono no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if (afiliado.getDireccion() == null || afiliado.getDireccion().isEmpty()) {
            throw new GlobalExcepcion("La dirección no puede estar vacía.", HttpStatus.BAD_REQUEST);
        }
        /*if (afiliado.getEmail() == null || afiliado.getEmail().isEmpty()) {
            throw new GlobalExcepcion("El email no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }*/
        if (afiliado.getFechaIngreso() == null) {
            throw new GlobalExcepcion("La fecha de ingreso no puede estar vacía.", HttpStatus.BAD_REQUEST);
        }
        /*if (afiliado.getFechaRetiro() == null) {
            throw new GlobalExcepcion("La fecha de retiro no puede estar vacía.", HttpStatus.BAD_REQUEST);
        }*/
    }


}
