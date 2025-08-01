package com.challenge.forohub.ForoHub.domain.topico.validations;

import com.challenge.forohub.ForoHub.infra.exceptions.ValidationException;
import com.challenge.forohub.ForoHub.domain.topico.DatosRegistroTopico;
import com.challenge.forohub.ForoHub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarDuplicados {

    @Autowired
    private TopicoRepository topicoRepository;

    public void validarTopico(DatosRegistroTopico datos){
        //buscar en el repository si el titulo y mensaje son iguales
        var tituloYMensaje = topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());

        if(tituloYMensaje){
            throw new ValidationException("Ese topico ya existe, cambia el titulo o mensaje");
        }
    }
}
