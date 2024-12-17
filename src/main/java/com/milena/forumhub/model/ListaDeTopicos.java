package com.milena.forumhub.model;

import java.time.LocalDateTime;

public record ListaDeTopicos(Long id, String titulo, String mensagem, LocalDateTime dataCriacao) {

    public ListaDeTopicos(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao());
    }
}
