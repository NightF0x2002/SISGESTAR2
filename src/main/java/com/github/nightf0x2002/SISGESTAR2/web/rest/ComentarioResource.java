package com.github.nightf0x2002.SISGESTAR2.web.rest;

import com.github.nightf0x2002.SISGESTAR2.domain.Comentario;
import com.github.nightf0x2002.SISGESTAR2.service.ComentarioService;
import com.github.nightf0x2002.SISGESTAR2.service.dto.ComentarioDTO;
import com.github.nightf0x2002.SISGESTAR2.service.dto.TarefaDTO;
import com.github.nightf0x2002.SISGESTAR2.service.mapper.ComentarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
@RequiredArgsConstructor
public class ComentarioResource {

    private final ComentarioService comentarioService;

    @GetMapping
    public ResponseEntity<List<ComentarioDTO>> recuperarTodos() {
        return ResponseEntity.ok(comentarioService.findAll());
    }

    @PostMapping
    public ResponseEntity<ComentarioDTO> create(@RequestBody ComentarioDTO comentarioDTO) {
        return ResponseEntity.ok(comentarioService.save(comentarioDTO));
    }
}
