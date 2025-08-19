package com.forumhub.service;

import com.forumhub.model.Usuario;
import com.forumhub.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario buscarPorUsername(String username) {
        Optional<Usuario> usuario = usuarioRepository.findByUsername(username);
        return usuario.orElse(null);
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
