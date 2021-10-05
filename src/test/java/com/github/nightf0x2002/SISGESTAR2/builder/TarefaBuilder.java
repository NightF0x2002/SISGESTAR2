package com.github.nightf0x2002.SISGESTAR2.builder;

import com.github.nightf0x2002.SISGESTAR2.domain.Tarefa;
import com.github.nightf0x2002.SISGESTAR2.repository.TarefaRepository;
import com.github.nightf0x2002.SISGESTAR2.service.dto.TarefaDTO;
import com.github.nightf0x2002.SISGESTAR2.service.mapper.TarefaMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TarefaBuilder {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private TarefaMapper tarefaMapper;

    public TarefaDTO createTarefaDTO() throws Exception {
        TarefaDTO tarefaDTO = new TarefaDTO();
        tarefaDTO.setNome("Título Teste");
        tarefaDTO.setDescricao("Descrição Teste");

        return tarefaDTO;
    }

    public TarefaDTO persistirTarefa(TarefaDTO tarefaDTO) {
        Tarefa tarefa =  tarefaMapper.toEntity(tarefaDTO);
        tarefa = tarefaRepository.save(tarefa);
        return tarefaMapper.toDTO(tarefa);
    }
}
