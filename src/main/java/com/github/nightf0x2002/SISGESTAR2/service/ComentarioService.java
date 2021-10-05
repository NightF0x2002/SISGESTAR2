package com.github.nightf0x2002.SISGESTAR2.service;

import com.github.nightf0x2002.SISGESTAR2.domain.Comentario;
import com.github.nightf0x2002.SISGESTAR2.repository.ComentarioRepository;
import com.github.nightf0x2002.SISGESTAR2.service.dto.ComentarioDTO;
import com.github.nightf0x2002.SISGESTAR2.service.mapper.ComentarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComentarioService {

    ComentarioRepository comentarioRepository;
    ComentarioMapper comentarioMapper;

    public List<ComentarioDTO> findAll() {
        return comentarioRepository
                .findAll()
                .stream().map(comentarioMapper::toListDTO)
                .collect(Collectors.toList());
    }

    public ComentarioDTO save(ComentarioDTO comentarioDTO) {
        Comentario usuario = comentarioMapper.toEntity(comentarioDTO);
        comentarioRepository.save(usuario);
        return comentarioMapper.toDTO(usuario);
    }

    public Optional<ComentarioDTO> findById(Long id) {
        return comentarioRepository.findById(id).map(comentarioMapper :: toDTO);
    }

    public void deleteById(Long id) {
        comentarioRepository.deleteById(id);
    }

}
