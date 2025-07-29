package com.challenge.forohub.ForoHub.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.challenge.forohub.ForoHub.domain.usuario.Usuario;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String generarToken(Usuario usuario){
        try {
            var algoritmo = Algorithm.HMAC256("shhh");

            return JWT.create()
                    .withIssuer("ForoHub")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(fechaExpiracion())
                    .sign(algoritmo);

        } catch (JWTCreationException exception){
            // Invalid Signing configuration / Couldn't convert Claims.
            throw new RuntimeException("Error al generar el token jwt", exception);
        }
    }

    private Instant fechaExpiracion(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public String getSubject(String tokenJwt){
        try{
            var algoritmo = Algorithm.HMAC256("shhh");

            return JWT.require(algoritmo)
                    .withIssuer("ForoHub")
                    .build()
                    .verify(tokenJwt)
                    .getSubject();

        }catch (JWTVerificationException exception){
            throw new RuntimeException("Token Jwt invalido o expirado",exception);
        }

    }

}
