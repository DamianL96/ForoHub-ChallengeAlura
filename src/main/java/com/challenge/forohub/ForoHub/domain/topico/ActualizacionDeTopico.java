package com.challenge.forohub.ForoHub.domain.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActualizacionDeTopico {
    @Autowired
    private TopicoRepository repository;

    public void actualizarTopico(DatosActualizacionTopico datos){

    }
}
