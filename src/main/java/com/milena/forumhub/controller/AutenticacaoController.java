package com.milena.forumhub.controller;

import com.milena.forumhub.config.TokenService;
import com.milena.forumhub.domain.usuario.DadosAutenticacao;
import com.milena.forumhub.domain.usuario.Usuario;
import com.milena.forumhub.infra.DadosTokenJWT;
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
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        // Cria um token para autenticação
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

        // Realiza a autenticação
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        // Gera o token com base no usuário autenticado
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));


        //var usuarioAutenticado = (Usuario) authentication.getPrincipal();
       //String token = tokenService.gerarToken(usuarioAutenticado);

        // Retorna o token em uma resposta de sucesso
        //return ResponseEntity.ok(token);
    }
}
