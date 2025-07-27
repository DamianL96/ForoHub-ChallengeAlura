package com.challenge.forohub.ForoHub.domain.topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
       Long id,
       String titulo,
       String mensaje,
       LocalDateTime fechaCreacion,
       String status,
       Curso curso
) {
    public DatosDetalleTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getCurso()
        );
    }
}
