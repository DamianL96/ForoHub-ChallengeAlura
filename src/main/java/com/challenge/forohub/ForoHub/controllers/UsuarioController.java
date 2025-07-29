package com.challenge.forohub.ForoHub.controllers;

import com.challenge.forohub.ForoHub.domain.usuario.DatosRegistroUsuario;
import com.challenge.forohub.ForoHub.domain.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/usuario")
@RestController
public class UsuarioController {


/*
    @Transactional
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody @Valid DatosRegistroUsuario datos){
        var usuario = new Usuario(datos);

    }*/
}
