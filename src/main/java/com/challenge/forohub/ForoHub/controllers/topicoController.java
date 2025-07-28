package com.challenge.forohub.ForoHub.controllers;

import com.challenge.forohub.ForoHub.domain.topico.*;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/topicos")
@RestController
public class topicoController {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    RegistroDeTopicos registro;

    @Transactional
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody @Valid DatosRegistroTopico datos){

        registro.registrarTopico(datos); //validamos

        return ResponseEntity.ok("Topico registrado con existo");
    }

    @GetMapping
    public ResponseEntity listar(){
        //hacer un dto para listar solo con titulo y fecha
        var listado = topicoRepository.findAll()
                .stream().map(DatosDetalleTopico::new).toList();
        return ResponseEntity.ok(listado);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalle(@PathVariable Long id){
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }
}
