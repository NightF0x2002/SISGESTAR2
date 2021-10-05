package com.github.nightf0x2002.SISGESTAR2.web.rest;

import com.github.nightf0x2002.SISGESTAR2.service.TarefaService;
import com.github.nightf0x2002.SISGESTAR2.service.dto.TarefaDTO;
import com.github.nightf0x2002.SISGESTAR2.service.dto.TarefaListDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
@RequiredArgsConstructor
public class TarefaResource {

    private final TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<TarefaListDTO>> findAll() {
        return ResponseEntity.ok(tarefaService.findAll());
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> create(@RequestBody TarefaDTO tarefa) {
        return ResponseEntity.ok(tarefaService.save(tarefa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.of(tarefaService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaDTO> update(@PathVariable("id") Long id,
                                            @RequestBody TarefaDTO tarefa) {
        tarefa.setId(id);
        return ResponseEntity.ok(tarefaService.save(tarefa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        tarefaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TarefaDTO> atualizarStatus(@PathVariable("id") Long id,
                                                     @RequestBody TarefaDTO tarefa,
                                                     @RequestParam("hash") String hash) {
        tarefa.setId(id);
        return ResponseEntity.ok(tarefaService.atualizarStatus(tarefa, hash));
    }
}
