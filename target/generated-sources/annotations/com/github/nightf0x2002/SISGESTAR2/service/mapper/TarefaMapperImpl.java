package com.github.nightf0x2002.SISGESTAR2.service.mapper;

import com.github.nightf0x2002.SISGESTAR2.domain.Tarefa;
import com.github.nightf0x2002.SISGESTAR2.domain.Usuario;
import com.github.nightf0x2002.SISGESTAR2.service.dto.TarefaDTO;
import com.github.nightf0x2002.SISGESTAR2.service.dto.TarefaListDTO;
import com.github.nightf0x2002.SISGESTAR2.service.dto.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-05T14:15:15-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_292 (Private Build)"
)
@Component
public class TarefaMapperImpl implements TarefaMapper {

    @Override
    public Tarefa toEntity(TarefaDTO tarefaDTO) {
        if ( tarefaDTO == null ) {
            return null;
        }

        Tarefa tarefa = new Tarefa();

        tarefa.setResponsavel( tarefaDTOToUsuario( tarefaDTO ) );
        tarefa.setId( tarefaDTO.getId() );
        tarefa.setDescricao( tarefaDTO.getDescricao() );
        tarefa.setAcompanhadores( usuarioDTOListToUsuarioList( tarefaDTO.getAcompanhadores() ) );

        verificaElementosNulos( tarefa );

        return tarefa;
    }

    @Override
    public TarefaDTO toDTO(Tarefa tarefa) {
        if ( tarefa == null ) {
            return null;
        }

        TarefaDTO tarefaDTO = new TarefaDTO();

        tarefaDTO.setIdResponsavel( tarefaResponsavelId( tarefa ) );
        tarefaDTO.setId( tarefa.getId() );
        tarefaDTO.setDescricao( tarefa.getDescricao() );
        tarefaDTO.setAcompanhadores( usuarioListToUsuarioDTOList( tarefa.getAcompanhadores() ) );

        return tarefaDTO;
    }

    @Override
    public TarefaListDTO toListDTO(Tarefa tarefa) {
        if ( tarefa == null ) {
            return null;
        }

        TarefaListDTO tarefaListDTO = new TarefaListDTO();

        tarefaListDTO.setId( tarefa.getId() );

        return tarefaListDTO;
    }

    protected Usuario tarefaDTOToUsuario(TarefaDTO tarefaDTO) {
        if ( tarefaDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( tarefaDTO.getIdResponsavel() );

        return usuario;
    }

    protected Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( usuarioDTO.getId() );
        usuario.setNome( usuarioDTO.getNome() );
        usuario.setEmail( usuarioDTO.getEmail() );
        usuario.setHash( usuarioDTO.getHash() );

        return usuario;
    }

    protected List<Usuario> usuarioDTOListToUsuarioList(List<UsuarioDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Usuario> list1 = new ArrayList<Usuario>( list.size() );
        for ( UsuarioDTO usuarioDTO : list ) {
            list1.add( usuarioDTOToUsuario( usuarioDTO ) );
        }

        return list1;
    }

    private Long tarefaResponsavelId(Tarefa tarefa) {
        if ( tarefa == null ) {
            return null;
        }
        Usuario responsavel = tarefa.getResponsavel();
        if ( responsavel == null ) {
            return null;
        }
        Long id = responsavel.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected UsuarioDTO usuarioToUsuarioDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId( usuario.getId() );
        usuarioDTO.setNome( usuario.getNome() );
        usuarioDTO.setEmail( usuario.getEmail() );
        usuarioDTO.setHash( usuario.getHash() );

        return usuarioDTO;
    }

    protected List<UsuarioDTO> usuarioListToUsuarioDTOList(List<Usuario> list) {
        if ( list == null ) {
            return null;
        }

        List<UsuarioDTO> list1 = new ArrayList<UsuarioDTO>( list.size() );
        for ( Usuario usuario : list ) {
            list1.add( usuarioToUsuarioDTO( usuario ) );
        }

        return list1;
    }
}
