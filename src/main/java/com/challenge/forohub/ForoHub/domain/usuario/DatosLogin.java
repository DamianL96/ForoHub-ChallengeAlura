package com.challenge.forohub.ForoHub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosLogin(
        @NotBlank String email,
        @NotBlank String password
){}
