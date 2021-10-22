package com.github.nightf0x2002.SISGESTAR2.service.mapper;

import com.github.nightf0x2002.SISGESTAR2.domain.Tarefa;
import com.github.nightf0x2002.SISGESTAR2.domain.Usuario;
import com.github.nightf0x2002.SISGESTAR2.service.dto.TarefaDTO;
import com.github.nightf0x2002.SISGESTAR2.service.dto.UsuarioDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UsuarioMapper extends EntityMapper<Usuario, UsuarioDTO> {

    @Override
    UsuarioDTO toDTO(Usuario usuario);

    @Override
    Usuario toEntity(UsuarioDTO usuarioDTO);

    UsuarioDTO toListDTO(Usuario usuario);

}
