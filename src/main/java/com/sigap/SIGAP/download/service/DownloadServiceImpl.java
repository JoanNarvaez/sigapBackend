package com.sigap.SIGAP.download.service;


import com.sigap.SIGAP.afiliado.entity.Afiliado;

import com.sigap.SIGAP.afiliado.service.AfiliadoService;
import com.sigap.SIGAP.empresa.entity.Empresa;
import com.sigap.SIGAP.empresa.service.EmpresaService;

import com.sigap.SIGAP.representante_legal.entity.RepresentanteLegal;

import com.sigap.SIGAP.representante_legal.service.RepresentateLegalService;
import com.sigap.SIGAP.reserva_especial.entity.ReservaEspecial;
import com.sigap.SIGAP.reserva_especial.service.ReservaEspecialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;


import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DownloadServiceImpl{

    private final AfiliadoService afiliadoService;
    private final EmpresaService empresaService;
    private final ReservaEspecialService reservaEspecialService;
    private final RepresentateLegalService representateLegalService;

    public String generateAllDataAsString() {
        StringBuilder sb = new StringBuilder();

        sb.append("AFILIADOS\n");
        sb.append(afiliadoService.ObtenerTodos().stream()
                .map(this::afiliadoToString)
                .collect(Collectors.joining("\n")));
        sb.append("\n\nEMPRESAS\n");
        sb.append(empresaService.ObtenerTodos().stream()
                .map(this::empresaToStringString)
                .collect(Collectors.joining("\n")));
        sb.append("\n\nRESERVAS ESPECIALES\n");
        sb.append(reservaEspecialService.ObtenerTodos().stream()
                .map(this::reservaEspecialToString)
                .collect(Collectors.joining("\n")));
        sb.append("\n\nREPRESENTANTES LEGALES\n");
        sb.append(representateLegalService.ObtenerTodos().stream()
                .map(this::representanteLegalToString)
                .collect(Collectors.joining("\n")));

        return sb.toString();
    }

    private String afiliadoToString(Afiliado afiliado) {
        return String.format("%d|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s",
                afiliado.getId(),
                afiliado.getTipoDocumento(),
                afiliado.getNumeroIdentificacion(),
                afiliado.getPrimerApeliido(),
                afiliado.getSegundoApeliido(),
                afiliado.getPrimerNombre(),
                afiliado.getSegundoNombre(),
                afiliado.getFechaNacimiento(),
                afiliado.getGenero(),
                afiliado.getCodigoMunicipio(),
                afiliado.getIndicador(),
                afiliado.getTelefono(),
                afiliado.getDireccion(),
                afiliado.getEmail(),
                afiliado.getFechaIngreso(),
                afiliado.getFechaRetiro()
        );
    }

    private String empresaToStringString(Empresa empresa) {
        return String.format("%d|%s|%s|%d|%d|%d|%s|%d|%s|%s|%s|%d|%d|%d|%d|%d|%d",
                empresa.getId(),
                empresa.getTipoIdentificacion(),
                empresa.getRazonSocial(),
                empresa.getNumeroNit(),
                empresa.getDigitoVerificacion(),
                empresa.getTipoEntidad(),
                empresa.getCodigoMunicipio(),
                empresa.getActividadEconomica(),
                empresa.getTelefono(),
                empresa.getDireccion(),
                empresa.getEmail(),
                empresa.getValorActivo(),
                empresa.getValorPasivo(),
                empresa.getValorPatrimonio(),
                empresa.getValorPatrimonioSin(),
                empresa.getValorReservaE(),
                empresa.getValorContable()
        );
    }

    private String reservaEspecialToString(ReservaEspecial reservaEspecial) {
        return String.format("%d|%s|%d|%s|%d|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s",
                reservaEspecial.getId(),
                reservaEspecial.getTipoIdentificacion(),
                reservaEspecial.getTipoPersona(),
                reservaEspecial.getNumeroIdentificacion(),
                reservaEspecial.getDigitoVerificacion(),
                reservaEspecial.getRazonSocial(),
                reservaEspecial.getPrimerApeliido(),
                reservaEspecial.getSegundoApeliido(),
                reservaEspecial.getPrimerNombre(),
                reservaEspecial.getSegundoNombre(),
                reservaEspecial.getTarjetaProfecional(),
                reservaEspecial.getCodigoMunicipio(),
                reservaEspecial.getTelefono(),
                reservaEspecial.getDireccion(),
                reservaEspecial.getEmail()
        );
    }

    private String representanteLegalToString(RepresentanteLegal representanteLegal) {
        return String.format("%d|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s",
                representanteLegal.getId(),
                representanteLegal.getTipoIdentificacion(),
                representanteLegal.getNumeroIdentificacion(),
                representanteLegal.getPrimerApeliido(),
                representanteLegal.getSegundoApeliido(),
                representanteLegal.getPrimerNombre(),
                representanteLegal.getSegundoNombre(),
                representanteLegal.getCodigoMunicipio(),
                representanteLegal.getTelefono(),
                representanteLegal.getDireccion(),
                representanteLegal.getEmail()
        );
    }
}