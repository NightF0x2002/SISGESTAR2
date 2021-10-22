package com.github.nightf0x2002.SISGESTAR2.repository;

import com.github.nightf0x2002.SISGESTAR2.domain.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
