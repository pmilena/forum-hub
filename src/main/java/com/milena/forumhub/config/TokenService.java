package com.milena.forumhub.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.milena.forumhub.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${JWT_SECRET:12345678}")
    private String secret;

    public String gerarToken(Usuario usuario){
    try {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return  JWT.create()
                .withIssuer("API ForumHub")
                .withSubject(usuario.getLogin())
                .withClaim("id", usuario.getId())
                .sign(algorithm);
    } catch (JWTCreationException exception){
        throw new RuntimeException("erro ao gerar token jwt, exception");
    }
}
private Instant dataExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-3:00"));
}

public String getSubject(String tokenJWT){
    try {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return  JWT.require(algorithm)
                .withIssuer("API ForumHub")
                .build()
                .verify(tokenJWT)
                .getSubject();
    } catch (JWTCreationException exception){
        throw new RuntimeException("Token JWT inválido ou expirado");
    }
}
}
