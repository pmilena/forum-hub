package com.milena.forumhub.repository;

import com.milena.forumhub.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuariosRepository extends JpaRepository<Usuario,Long> {

    UserDetails findByLogin(String username);
}
