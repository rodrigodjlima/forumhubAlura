package com.forumhub.controller;

import com.forumhub.dto.TopicoDTO;
import com.forumhub.model.Topico;
import com.forumhub.service.TopicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
@RequiredArgsConstructor
public class TopicoController {

    private final TopicoService topicoService;

    @PostMapping
    public ResponseEntity<?> criarTopico(@RequestBody @Valid TopicoDTO dto) {
        Topico topico = new Topico();
        topico.setTitulo(dto.getTitulo());
        topico.setMensagem(dto.getMensagem());
        topico.setEstado(dto.getEstado());
        topico.setAutor(dto.getAutor());
        topico.setCurso(dto.getCurso());

        return ResponseEntity.ok(topicoService.salvarTopico(topico));
    }

    @GetMapping
    public ResponseEntity<List<Topico>> listarTopicos() {
        return ResponseEntity.ok(topicoService.listarTopicos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarTopico(@PathVariable Long id, @RequestBody @Valid TopicoDTO dto) {
        Topico topico = new Topico();
        topico.setTitulo(dto.getTitulo());
        topico.setMensagem(dto.getMensagem());
        topico.setEstado(dto.getEstado());
        topico.setAutor(dto.getAutor());
        topico.setCurso(dto.getCurso());

        return ResponseEntity.ok(topicoService.atualizarTopico(id, topico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarTopico(@PathVariable Long id) {
        topicoService.deletarTopico(id);
        return ResponseEntity.ok("Tópico deletado com sucesso");
    }
}
