package com.github.nightf0x2002.SISGESTAR2.repository;

import com.github.nightf0x2002.SISGESTAR2.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value =
            "SELECT " +
                    "   * " +
                    "FROM " +
                    "   usuario " +
                    "WHERE" +
                    "   usuario.hash = :hash", nativeQuery = true)
    Optional<Usuario> findByHash(@Param("hash") String hash);
}
