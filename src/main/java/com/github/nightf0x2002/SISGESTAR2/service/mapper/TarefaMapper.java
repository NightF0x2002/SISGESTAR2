package com.github.nightf0x2002.SISGESTAR2.service.mapper;

import com.github.nightf0x2002.SISGESTAR2.domain.Tarefa;
import com.github.nightf0x2002.SISGESTAR2.domain.Usuario;
import com.github.nightf0x2002.SISGESTAR2.domain.enumarations.StatusTarefaEnum;
import com.github.nightf0x2002.SISGESTAR2.service.dto.TarefaDTO;
import com.github.nightf0x2002.SISGESTAR2.service.dto.TarefaListDTO;
import org.aspectj.lang.annotation.After;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Objects;
import java.util.Optional;

@Mapper
public interface TarefaMapper extends EntityMapper<Tarefa, TarefaDTO> {

    @Override
    @Mapping(source = "idResponsavel", target = "responsavel.id")
    Tarefa toEntity(TarefaDTO tarefaDTO);

    @Override
    @Mapping(source = "responsavel.id", target = "idResponsavel")
    TarefaDTO toDTO(Tarefa tarefa);

    TarefaListDTO toListDTO(Tarefa tarefa);

    @AfterMapping
    default void verificaElementosNulos(@MappingTarget Tarefa tarefa) {
        tarefa.setResponsavel(
                Optional.ofNullable(tarefa.getResponsavel()).orElseGet(Usuario::new));
        if (Objects.isNull(tarefa.getResponsavel().getId())) {
            tarefa.setResponsavel(null);
        }
    }

    @AfterMapping
    default void atualizarDescricaoStatus(@MappingTarget TarefaDTO tarefaDTO) {
        StatusTarefaEnum statusTarefaEnum = StatusTarefaEnum.obterPorId(tarefaDTO.getIdStatus());
        tarefaDTO.setDescricaoStatus(statusTarefaEnum.getDescricao());
    }
}
