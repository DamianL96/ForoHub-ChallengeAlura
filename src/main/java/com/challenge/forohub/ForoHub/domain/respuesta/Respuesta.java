package com.challenge.forohub.ForoHub.domain.respuesta;

import com.challenge.forohub.ForoHub.domain.topico.Topico;
import com.challenge.forohub.ForoHub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    private LocalDateTime fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;

    public Respuesta(DatosRegistroRespuesta nuevaRespuesta, Usuario usuario, Topico topico){
        this.id = null;
        this.mensaje = nuevaRespuesta.mensaje();
        this.fechaCreacion = LocalDateTime.now();

        this.usuario = usuario;
        this.topico = topico;
    }
}
