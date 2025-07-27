package com.challenge.forohub.ForoHub.controllers;

import com.challenge.forohub.ForoHub.domain.topico.DatosRegistroTopico;
import com.challenge.forohub.ForoHub.domain.topico.RegistroDeTopicos;
import com.challenge.forohub.ForoHub.domain.topico.Topico;
import com.challenge.forohub.ForoHub.domain.topico.TopicoRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
