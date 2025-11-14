package com.salesianostriana.dam.rest.error;

public class MonumentNotFoundException extends RuntimeException {
    public MonumentNotFoundException(String message) {
        super(message);
    }


    public MonumentNotFoundException(Long id){
        super("No hay un monumento con ese ID: %d".formatted(id));
    }

    public MonumentNotFoundException() {
        super("No hay monumentos con esos requisitos de búsqueda");

    }

}
