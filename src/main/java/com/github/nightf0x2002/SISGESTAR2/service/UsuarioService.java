package com.github.nightf0x2002.SISGESTAR2.service;

import com.github.nightf0x2002.SISGESTAR2.domain.Usuario;
import com.github.nightf0x2002.SISGESTAR2.repository.UsuarioRepository;
import com.github.nightf0x2002.SISGESTAR2.service.dto.UsuarioDTO;
import com.github.nightf0x2002.SISGESTAR2.service.error.UsuarioNaoEncontradoException;
import com.github.nightf0x2002.SISGESTAR2.service.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setHash(UUID.randomUUID().toString());
        usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuario);
    }

    public UsuarioDTO obterPorId(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(UsuarioNaoEncontradoException::new);
        return usuarioMapper.toDTO(usuario);
    }

    public Optional<UsuarioDTO> obterPorHash(String hash) {
        return usuarioRepository.findByHash(hash).map(usuarioMapper::toDTO);
    }
}

