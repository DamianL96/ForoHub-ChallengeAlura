package com.challenge.forohub.ForoHub.controllers;
import com.challenge.forohub.ForoHub.domain.usuario.DatosLogin;
import com.challenge.forohub.ForoHub.domain.usuario.Usuario;
import com.challenge.forohub.ForoHub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager autManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity iniciarSesion(@Valid @RequestBody DatosLogin datos){

        //creamos el token
        var token = new UsernamePasswordAuthenticationToken(datos.email(), datos.password());
        var autenticacion = autManager.authenticate(token); //reliza la autenticacion

        return ResponseEntity.ok(tokenService.generarToken((Usuario) autenticacion.getPrincipal()));
    }
}
