package com.github.nightf0x2002.SISGESTAR2.service.mapper;

import com.github.nightf0x2002.SISGESTAR2.domain.Comentario;
import com.github.nightf0x2002.SISGESTAR2.service.dto.ComentarioDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ComentarioMapper extends EntityMapper<Comentario, ComentarioDTO> {

    @Override
    Comentario toEntity(ComentarioDTO comentarioDTO);

    @Override
    ComentarioDTO toDTO(Comentario comentario);

    ComentarioDTO toListDTO(Comentario comentario);

}
