package com.challenge.forohub.ForoHub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull LocalDateTime fechaCreacion,
        @NotNull Estado status,
        int usuarioId,
        @NotNull Curso curso
){}
