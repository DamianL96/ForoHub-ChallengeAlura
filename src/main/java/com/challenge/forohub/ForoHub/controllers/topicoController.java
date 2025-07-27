package com.challenge.forohub.ForoHub.controllers;

import com.challenge.forohub.ForoHub.domain.topico.DatosRegistroTopico;
import com.challenge.forohub.ForoHub.domain.topico.Topico;
import com.challenge.forohub.ForoHub.domain.topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid DatosRegistroTopico datos){
        //creamos el objeto topico
        var topico = new Topico(datos);
        //lo mandamos a guardar repository.save
        topicoRepository.save(topico);
    }
}
