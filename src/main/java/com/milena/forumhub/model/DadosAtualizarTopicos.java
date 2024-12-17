package com.milena.forumhub.model;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizarTopicos(String titulo,
                                    String mensagem,
                                    String autor,
                                    String curso) {
}
