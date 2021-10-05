package com.github.nightf0x2002.SISGESTAR2.service.mapper;

import com.github.nightf0x2002.SISGESTAR2.domain.Tarefa;
import com.github.nightf0x2002.SISGESTAR2.service.dto.TarefaDTO;
import com.github.nightf0x2002.SISGESTAR2.service.dto.TarefaListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TarefaMapper extends EntityMapper<Tarefa, TarefaDTO> {

    @Override
    @Mapping(source = "idResponsavel", target = "responsavel.id")
    Tarefa toEntity(TarefaDTO tarefaDTO);

    @Override
    @Mapping(source = "responsavel.id", target = "idResponsavel")
    TarefaDTO toDTO(Tarefa tarefa);

    TarefaListDTO toListDTO(Tarefa tarefa);
}
