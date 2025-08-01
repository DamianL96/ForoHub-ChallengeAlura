package com.challenge.forohub.ForoHub.controllers;

import com.challenge.forohub.ForoHub.domain.usuario.DatosRegistroUsuario;
import com.challenge.forohub.ForoHub.domain.usuario.RegistrarUsuario;
import com.challenge.forohub.ForoHub.infra.exceptions.RegistroException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/usuario")
@RestController
public class UsuarioController {

    @Autowired
    RegistrarUsuario registrarUsuario;

    @Transactional
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody @Valid DatosRegistroUsuario datos){
        try{
            registrarUsuario.registrar(datos); //servicio comprueba que el email no este repetido
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado existosamente");

        }catch (RegistroException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
