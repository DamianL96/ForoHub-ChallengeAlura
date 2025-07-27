package com.challenge.forohub.ForoHub.domain.topico;

import com.challenge.forohub.ForoHub.domain.topico.validations.ValidarDuplicados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroDeTopicos {

    @Autowired
    TopicoRepository repository;

    @Autowired
    ValidarDuplicados validar;

    public void registrarTopico(DatosRegistroTopico datos){

        //validar
        validar.validarTopico(datos);

        var topico = new Topico(datos);
        repository.save(topico);
    }

}
