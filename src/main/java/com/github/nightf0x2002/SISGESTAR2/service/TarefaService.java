package com.github.nightf0x2002.SISGESTAR2.service;

import com.github.nightf0x2002.SISGESTAR2.domain.Tarefa;
import com.github.nightf0x2002.SISGESTAR2.domain.enumarations.StatusTarefaEnum;
import com.github.nightf0x2002.SISGESTAR2.repository.TarefaRepository;
import com.github.nightf0x2002.SISGESTAR2.service.dto.TarefaDTO;
import com.github.nightf0x2002.SISGESTAR2.service.dto.TarefaListDTO;
import com.github.nightf0x2002.SISGESTAR2.service.error.TarefaNaoEncontradaException;
import com.github.nightf0x2002.SISGESTAR2.service.error.UsuarioNaoAutorizadoException;
import com.github.nightf0x2002.SISGESTAR2.service.mapper.TarefaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final TarefaMapper tarefaMapper;

    public List<TarefaListDTO> findAll() {
        return tarefaRepository
                .findAll()
                .stream().map(tarefaMapper::toListDTO)
                .collect(Collectors.toList());
    }

    public TarefaDTO save(TarefaDTO tarefaDTO) {
        Tarefa tarefa = tarefaMapper.toEntity(tarefaDTO);
        tarefa.setIdStatus(StatusTarefaEnum.A_FAZER.getId());
        tarefaRepository.save(tarefa);
        return tarefaMapper.toDTO(tarefa);
    }

    public Optional<TarefaDTO> findById(Long id) {
        return tarefaRepository.findById(id).map(tarefaMapper :: toDTO);
    }

    public void deleteById(Long id) {
        tarefaRepository.deleteById(id);
    }

    public TarefaDTO atualizarStatus(TarefaDTO tarefaDTO, String hash) {
        Tarefa tarefaEmBanco = tarefaRepository.findById(tarefaDTO.getId())
                .orElseThrow(TarefaNaoEncontradaException:: new);
        tarefaEmBanco.setIdStatus(tarefaDTO.getIdStaus());
        tarefaRepository.save(tarefaEmBanco);
        return tarefaMapper.toDTO(tarefaEmBanco);
    }

    private void validarResponsavel(Tarefa tarefa, String hash) {
        if(!tarefa.getResponsavel().getHash().equals(hash)){
            throw new UsuarioNaoAutorizadoException();
        }
    }
}
