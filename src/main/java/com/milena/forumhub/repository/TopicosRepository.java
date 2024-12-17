package com.milena.forumhub.repository;

import com.milena.forumhub.domain.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicosRepository extends JpaRepository<Topico,Long> {

}
