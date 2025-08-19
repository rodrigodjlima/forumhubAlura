package com.forumhub.service;

import com.forumhub.model.Topico;
import com.forumhub.repository.TopicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicoService {

    private final TopicoRepository topicoRepository;

    public Topico salvarTopico(Topico topico) {
        Optional<Topico> existente = topicoRepository.findByTituloAndMensagem(topico.getTitulo(), topico.getMensagem());
        if (existente.isPresent()) {
            throw new RuntimeException("Tópico duplicado!");
        }
        return topicoRepository.save(topico);
    }

    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }

    public Topico atualizarTopico(Long id, Topico novoTopico) {
        return topicoRepository.findById(id).map(topico -> {
            topico.setTitulo(novoTopico.getTitulo());
            topico.setMensagem(novoTopico.getMensagem());
            topico.setEstado(novoTopico.getEstado());
            topico.setAutor(novoTopico.getAutor());
            topico.setCurso(novoTopico.getCurso());
            return topicoRepository.save(topico);
        }).orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
    }

    public void deletarTopico(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new RuntimeException("Tópico não encontrado");
        }
        topicoRepository.deleteById(id);
    }
}
