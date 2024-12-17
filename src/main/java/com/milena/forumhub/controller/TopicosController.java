package com.milena.forumhub.controller;


import com.milena.forumhub.model.DadosAtualizarTopicos;
import com.milena.forumhub.model.DadosCadastroTopico;
import com.milena.forumhub.model.ListaDeTopicos;
import com.milena.forumhub.model.Topico;
import com.milena.forumhub.repository.TopicosRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicosRepository topicosRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroTopico dados) {
        topicosRepository.save(new Topico(dados));
    }

    @GetMapping
    public Page<ListaDeTopicos> listar(@PageableDefault(size = 5) Pageable paginacao) {
        return topicosRepository.findAll(paginacao)
                .map(topico -> new ListaDeTopicos(topico));
    }


    @GetMapping("/{id}")
    public ResponseEntity<DadosCadastroTopico> detalhar(@PathVariable Long id) {
        var topico = topicosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));

        DadosCadastroTopico dados = new DadosCadastroTopico(
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getAutor(),
                topico.getCurso()
        );
        return ResponseEntity.ok(dados);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarTopicos dados, @PathVariable Long id) {
        var topico = topicosRepository.getReferenceById(id);
        topico.atualizarDados(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        Optional<Topico> topicoOptional = topicosRepository.findById(id);

        if (topicoOptional.isPresent()) {
            topicosRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
        }
    }



}
