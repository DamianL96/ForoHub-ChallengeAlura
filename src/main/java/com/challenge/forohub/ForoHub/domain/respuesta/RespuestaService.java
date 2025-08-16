package com.challenge.forohub.ForoHub.domain.respuesta;

import com.challenge.forohub.ForoHub.domain.topico.TopicoRepository;
import com.challenge.forohub.ForoHub.domain.usuario.UsuarioRepository;
import com.challenge.forohub.ForoHub.infra.exceptions.RegistroException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaService {

    @Autowired
    RespuestaRepository respuestaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TopicoRepository topicoRepository;

    public List<Respuesta> obtenerPorTopico(Long id){
        return respuestaRepository.findByTopicoId(id);
    }

    public void registrarRespuesta(DatosRegistroRespuesta datos){
        var usuario= usuarioRepository.findById(datos.idUsuario());
        if(usuario.isEmpty()){
            throw new RegistroException("El usuario no existe");
        }

        var topico= topicoRepository.findById(datos.idTopico());
        if (topico.isEmpty()){
            throw new RegistroException("El topico no existe");
        }

        var respuesta= new Respuesta(datos, usuario.get(), topico.get());
        respuestaRepository.save(respuesta);
    }
}
