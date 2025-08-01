package com.challenge.forohub.ForoHub.domain.topico;

import com.challenge.forohub.ForoHub.domain.topico.validations.ValidarDuplicados;
import com.challenge.forohub.ForoHub.domain.usuario.UsuarioRepository;
import com.challenge.forohub.ForoHub.infra.exceptions.RegistroException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroDeTopicos {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ValidarDuplicados validar;

    public void registrarTopico(DatosRegistroTopico datos){

        //validar
        var usuario= usuarioRepository.findById(datos.idUsuario());
        if(usuario.isEmpty()){
            throw new RegistroException("El usuario no existe");
        }

        validar.validarTopico(datos);
        var topico = new Topico(datos, usuario.get());
        topicoRepository.save(topico);
    }

}
