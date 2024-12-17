package com.milena.forumhub.controller;

import com.milena.forumhub.domain.usuario.DadosAutenticacao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        // Cria um token para autenticação
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

        // Realiza a autenticação
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        // Retorna uma resposta de sucesso
        return ResponseEntity.ok().build();
    }
}
