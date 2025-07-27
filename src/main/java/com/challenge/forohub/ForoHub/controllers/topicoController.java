package com.challenge.forohub.ForoHub.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/topicos")
@RestController
public class topicoController {


    @Transactional
    @PostMapping
    public void registrar(){

    }
}
