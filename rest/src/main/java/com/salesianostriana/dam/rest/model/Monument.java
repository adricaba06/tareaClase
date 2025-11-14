package com.salesianostriana.dam.rest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoPais;
    private String nombrePais;
    private String ciudad;
    private Double latitud;
    private Double longitud;
    private String nombreMonumento;
    @Lob
    private String descripcion;
    private String urlFoto;

}
