package com.challenge.forohub.ForoHub.controllers;

import com.challenge.forohub.ForoHub.domain.respuesta.DatosListarRespuesta;
import com.challenge.forohub.ForoHub.domain.respuesta.DatosRegistroRespuesta;
import com.challenge.forohub.ForoHub.domain.respuesta.Respuesta;
import com.challenge.forohub.ForoHub.domain.respuesta.RespuestaService;
import com.challenge.forohub.ForoHub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/topicos")
@RestController
public class TopicoController {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    RegistroDeTopicos registro;

    @Autowired
    RespuestaService respuestaService;

    @Transactional
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody @Valid DatosRegistroTopico datos){

        registro.registrarTopico(datos); //validamos

        return ResponseEntity.ok("Topico registrado con existo");
    }

    @GetMapping
    public ResponseEntity listar(){
        //hacer un dto para listar solo con titulo y fecha
        var listado = topicoRepository.findAll()
                .stream().map(DatosListaTopico::new).toList();
        return ResponseEntity.ok(listado);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalle(@PathVariable Long id){
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizacionTopico datos){
        Optional<Topico> topicoOptional = topicoRepository.findById(datos.id());

        //verificar si existe
        if(!topicoOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }

        //actualizamos el topico
        var topico = topicoOptional.get();
        topico.actualizar(datos);

        //devolvemos ok
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        Optional<Topico> topicoOptional = topicoRepository.findById(id);

        if(!topicoOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }

        topicoRepository.deleteById(id);
        return ResponseEntity.ok("Topico eliminado con exito");
    }


    @GetMapping("/{id}/respuestas")
    public ResponseEntity listaRespuestas(@PathVariable Long id){
        var todasLasRespuestas= respuestaService.obtenerPorTopico(id)
                .stream()
                .map(DatosListarRespuesta::new)
                .toList();
        return ResponseEntity.ok(todasLasRespuestas);
    }

    @Transactional
    @PostMapping("/{id}/respuestas")
    public  ResponseEntity<String> crearRespuesta(@RequestBody @Valid DatosRegistroRespuesta respuesta){
        respuestaService.registrarRespuesta(respuesta);
        return ResponseEntity.ok("Respuesta creada con exito");
    }


}
