package com.github.nightf0x2002.SISGESTAR2.repository;

import com.github.nightf0x2002.SISGESTAR2.domain.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
