package com.github.nightf0x2002.SISGESTAR2.web.rest;

import com.github.nightf0x2002.SISGESTAR2.domain.Usuario;
import com.github.nightf0x2002.SISGESTAR2.service.TarefaService;
import com.github.nightf0x2002.SISGESTAR2.service.UsuarioService;
import com.github.nightf0x2002.SISGESTAR2.service.dto.TarefaDTO;
import com.github.nightf0x2002.SISGESTAR2.service.dto.TarefaListDTO;
import com.github.nightf0x2002.SISGESTAR2.service.dto.UsuarioDTO;
import com.github.nightf0x2002.SISGESTAR2.service.dto.UsuarioListDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioResource {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.save(usuarioDTO));
    }

    @GetMapping("/obter-por-hash/{hash}")
    public ResponseEntity<UsuarioDTO> obterPorHash(@PathVariable("hash") String hash) {
        return ResponseEntity.of(usuarioService.obterPorHash(hash));
    }

}
