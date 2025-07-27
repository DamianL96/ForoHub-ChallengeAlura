package com.challenge.forohub.ForoHub.domain.topico;

import jakarta.persistence.*;
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

    private LocalDateTime fechaCreacion;

    private String status;

    private int usuarioId;

    private Curso curso;


    public Topico( DatosRegistroTopico nuevoTopico){
        this.id = null;
        this.titulo = nuevoTopico.titulo();
        this.mensaje = nuevoTopico.mensaje();
        this.fechaCreacion = nuevoTopico.fechaCreacion();
        this.status = nuevoTopico.status();
        this.usuarioId = nuevoTopico.usuarioId();
        this.curso = nuevoTopico.curso();
    }




}
