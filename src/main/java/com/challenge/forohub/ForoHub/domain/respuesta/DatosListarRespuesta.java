package com.challenge.forohub.ForoHub.domain.respuesta;

import com.challenge.forohub.ForoHub.domain.usuario.DatosListarUsuario;
import com.challenge.forohub.ForoHub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosListarRespuesta(
        String mensaje,
        LocalDateTime fechaCreacion,
        DatosListarUsuario usuario
) {
    public DatosListarRespuesta(Respuesta respuesta){
        this(
                respuesta.getMensaje(),
                respuesta.getFechaCreacion(),
                new DatosListarUsuario(respuesta.getUsuario())
        );
    }
}
