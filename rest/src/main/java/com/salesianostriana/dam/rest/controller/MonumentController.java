package com.salesianostriana.dam.rest.controller;


import com.salesianostriana.dam.rest.dto.NewMonumentCommand;
import com.salesianostriana.dam.rest.model.Monument;
import com.salesianostriana.dam.rest.service.MonumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monument")
@RequiredArgsConstructor
public class MonumentController {

    private final MonumentService ms;


    @GetMapping
    public List<Monument> getAll(){
        return ms.findAll();
    }

    @GetMapping("/{id}")
    public Monument getById(@PathVariable Long id){
        return ms.findById(id);
    }

    @PostMapping
    public ResponseEntity<Monument> create(
            @RequestBody NewMonumentCommand cmd
            ){
        return ResponseEntity.status(HttpStatus.CREATED).body(ms.save(cmd));
    }

    @PutMapping("/{id}")
    public Monument edit(@RequestBody NewMonumentCommand cmd, @PathVariable Long id){
        return ms.edit(cmd, id);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete(@PathVariable Long id){
        ms.delete(id);
        return ResponseEntity.noContent().build();
    }

}
