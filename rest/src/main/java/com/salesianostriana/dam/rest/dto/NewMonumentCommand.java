package com.salesianostriana.dam.rest.dto;

import jakarta.persistence.Lob;

public record NewMonumentCommand(
        Long id,
        String codigoPais,
        String nombrePais,
        String ciudad,
        Double latitud,
        Double longitud,
        String nombreMonumento,
        @Lob
        String descripcion,
        String urlFoto

) {


}
