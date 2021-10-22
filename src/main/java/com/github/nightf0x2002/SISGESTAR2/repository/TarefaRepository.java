package com.github.nightf0x2002.SISGESTAR2.repository;

import com.github.nightf0x2002.SISGESTAR2.domain.Tarefa;
import com.github.nightf0x2002.SISGESTAR2.service.dto.TarefaFilterDTO;
import com.github.nightf0x2002.SISGESTAR2.service.dto.TarefaListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Query(
            "SELECT new com.github.nightf0x2002.SISGESTAR2.service.dto.TarefaListDTO(" +
                    "   tarefa.id, " +
                    "   tarefa.nome " +
                    ") FROM " +
                    "   Tarefa tarefa " +
                    "WHERE " +
                    "   tarefa.nome LIKE %:#{#filtro.nome}%")
    Page<TarefaListDTO> filtrarTarefas(@Param("filtro") TarefaFilterDTO filterDTO, Pageable page);

}

