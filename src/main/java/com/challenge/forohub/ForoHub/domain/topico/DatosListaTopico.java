package com.challenge.forohub.ForoHub.domain.topico;

import java.time.LocalDateTime;

public record DatosListaTopico(
        String titulo,
        String nombreUsuario,
        LocalDateTime fechaCreacion,
        Estado status,
        Curso curso
) {
    public DatosListaTopico(Topico topico){
        this(
                topico.getTitulo(),
                topico.getUsuario().getNombre(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getCurso()
        );
    }
}
