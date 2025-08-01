package com.challenge.forohub.ForoHub.domain.topico;

import com.challenge.forohub.ForoHub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name ="Topico")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    @Column(name="fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Estado status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name="curso")
    @Enumerated(EnumType.STRING)
    private Curso curso;


    public Topico( DatosRegistroTopico nuevoTopico, Usuario usuario){
        this.id = null;
        this.titulo = nuevoTopico.titulo();
        this.mensaje = nuevoTopico.mensaje();
        this.fechaCreacion = nuevoTopico.fechaCreacion();
        this.status = nuevoTopico.status();
        this.usuario = usuario;
        this.curso = nuevoTopico.curso();
    }

    public void actualizar(@Valid DatosActualizacionTopico datos){
        if(datos.titulo() != null){
            this.titulo = datos.titulo();
        }
        if(datos.mensaje() != null){
            this.mensaje = datos.mensaje();
        }
        if(datos.status() != null){
            this.status = datos.status();
        }
        if(datos.curso() != null){
            this.curso = datos.curso();
        }
    }


}
