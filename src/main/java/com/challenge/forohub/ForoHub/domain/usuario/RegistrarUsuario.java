package com.challenge.forohub.ForoHub.domain.usuario;

import com.challenge.forohub.ForoHub.infra.exceptions.RegistroException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrarUsuario {

    @Autowired
    UsuarioRepository repository;

    public void registrar(DatosRegistroUsuario datos) throws RegistroException {

        var usuarioYaCreado = repository.findByEmail(datos.email());
        if(usuarioYaCreado != null){
            throw new RegistroException("Ese email ya se encuentra en la base de datos");
        }
        var nuevoUsuario = new Usuario(datos);
        repository.save(nuevoUsuario);
    }


}
