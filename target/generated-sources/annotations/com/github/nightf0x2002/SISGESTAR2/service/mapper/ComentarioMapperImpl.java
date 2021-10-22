package com.github.nightf0x2002.SISGESTAR2.service.mapper;

import com.github.nightf0x2002.SISGESTAR2.domain.Comentario;
import com.github.nightf0x2002.SISGESTAR2.service.dto.ComentarioDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-18T14:43:39-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
@Component
public class ComentarioMapperImpl implements ComentarioMapper {

    @Override
    public Comentario toEntity(ComentarioDTO comentarioDTO) {
        if ( comentarioDTO == null ) {
            return null;
        }

        Comentario comentario = new Comentario();

        comentario.setId( comentarioDTO.getId() );
        comentario.setTitulo( comentarioDTO.getTitulo() );
        comentario.setDescricao( comentarioDTO.getDescricao() );
        comentario.setData( comentarioDTO.getData() );

        return comentario;
    }

    @Override
    public ComentarioDTO toDTO(Comentario comentario) {
        if ( comentario == null ) {
            return null;
        }

        ComentarioDTO comentarioDTO = new ComentarioDTO();

        comentarioDTO.setId( comentario.getId() );
        comentarioDTO.setTitulo( comentario.getTitulo() );
        comentarioDTO.setDescricao( comentario.getDescricao() );
        comentarioDTO.setData( comentario.getData() );

        return comentarioDTO;
    }

    @Override
    public ComentarioDTO toListDTO(Comentario comentario) {
        if ( comentario == null ) {
            return null;
        }

        ComentarioDTO comentarioDTO = new ComentarioDTO();

        comentarioDTO.setId( comentario.getId() );
        comentarioDTO.setTitulo( comentario.getTitulo() );
        comentarioDTO.setDescricao( comentario.getDescricao() );
        comentarioDTO.setData( comentario.getData() );

        return comentarioDTO;
    }
}
