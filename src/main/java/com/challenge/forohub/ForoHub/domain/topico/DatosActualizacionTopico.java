package com.challenge.forohub.ForoHub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopico(
        @NotNull Long id,

        String titulo,
        String mensaje,
        Estado status,
        Curso curso
) {
    public DatosActualizacionTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getStatus(),
                topico.getCurso()
        );
    }
}
