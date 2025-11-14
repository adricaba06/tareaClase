package com.salesianostriana.dam.rest.service;

import com.salesianostriana.dam.rest.dto.NewMonumentCommand;
import com.salesianostriana.dam.rest.error.MonumentNotFoundException;
import com.salesianostriana.dam.rest.model.Monument;
import com.salesianostriana.dam.rest.repository.MonumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonumentService {
    @Autowired
    private MonumentRepository mr;


    public List<Monument> findAll(){
        List<Monument> result = mr.findAll();

        if(result.isEmpty()){
            throw new MonumentNotFoundException();

        }
        return result;
    }

    public Monument findById(Long id) {
        return mr.findById(id)
                .orElseThrow(() -> new MonumentNotFoundException(id));
    }

    public Monument save(NewMonumentCommand cmd) {
        return mr.save(
         Monument.builder()
                .codigoPais(cmd.codigoPais())
                .nombrePais(cmd.nombrePais())
                .ciudad(cmd.ciudad())
                .latitud(cmd.latitud())
                .longitud(cmd.longitud())
                .nombreMonumento(cmd.nombreMonumento())
                .descripcion(cmd.descripcion())
                .urlFoto(cmd.urlFoto())
                .build()
                );

    }

    public Monument edit(NewMonumentCommand cmd, Long id){
        return mr.findById(id).map( monument -> {
            monument.setCodigoPais(cmd.codigoPais());
            monument.setNombrePais(cmd.nombrePais());
            monument.setCiudad(cmd.ciudad());
            monument.setLatitud(cmd.latitud());
            monument.setLongitud(cmd.longitud());
            monument.setNombreMonumento(cmd.nombreMonumento());
            monument.setDescripcion(cmd.descripcion());
            monument.setUrlFoto(cmd.urlFoto());
            return mr.save(monument);
        }).orElseThrow(() -> new MonumentNotFoundException(id));


        }

        public void delete(Long id){
        mr.deleteById(id);
        }

}


