package com.challenge.forohub.ForoHub.domain.usuario;

public record DatosListarUsuario(
        Long id,
        String email,
        String nombre
) {
    public DatosListarUsuario(Usuario nuevo){
        this(
                nuevo.getId(),
                nuevo.getEmail(),
                nuevo.getNombre()
        );
    }
}
