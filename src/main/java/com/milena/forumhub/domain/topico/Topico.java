package com.milena.forumhub.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;
    
    private String autor;

    private String curso;

    private String resposta;

    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    private LocalDateTime dataCriacao;

    public Topico() {
    }

    public Topico(@Valid DadosCadastroTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.autor = dados.autor();
        this.curso = dados.curso();
        this.dataCriacao = LocalDateTime.now();
        this.status = Status.PENDENTE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void atualizarDados(@Valid DadosAtualizarTopicos dados) {
        Optional.ofNullable(dados.titulo()).ifPresent(titulo -> this.titulo = titulo);
        Optional.ofNullable(dados.mensagem()).ifPresent(mensagem -> this.mensagem = mensagem);
        Optional.ofNullable(dados.autor()).ifPresent(autor -> this.autor = autor);
        Optional.ofNullable(dados.curso()).ifPresent(curso -> this.curso = curso);
    }

}
