package com.github.nightf0x2002.SISGESTAR2.service;

import com.github.nightf0x2002.SISGESTAR2.domain.Usuario;
import com.github.nightf0x2002.SISGESTAR2.repository.UsuarioRepository;
import com.github.nightf0x2002.SISGESTAR2.service.dto.UsuarioDTO;
import com.github.nightf0x2002.SISGESTAR2.service.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public List<UsuarioDTO> findAll() {
        return usuarioRepository
                .findAll()
                .stream().map(usuarioMapper::toListDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuario);
    }

    public Optional<UsuarioDTO> findById(Long id) {
        return usuarioRepository.findById(id).map(usuarioMapper :: toDTO);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

}

