package com.github.nightf0x2002.SISGESTAR2.web.rest;

import com.github.nightf0x2002.SISGESTAR2.domain.Comentario;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
@RequiredArgsConstructor
public class ComentarioResource {

    List<Comentario> comentarios = new ArrayList<>();

    @GetMapping
    public List<Comentario> recuperarTodos() {
        return comentarios;
    }

    @PostMapping
    public Comentario criarComentario(@RequestBody Comentario novoComentario) {
        comentarios.add(novoComentario);
        return novoComentario;
    }
}
