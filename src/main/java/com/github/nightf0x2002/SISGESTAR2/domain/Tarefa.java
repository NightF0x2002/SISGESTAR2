package com.github.nightf0x2002.SISGESTAR2.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "tarefa")
@Entity
@Getter
@Setter
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_usuario_responsavel")
    private Usuario responsavel;

    @ManyToMany
    @JoinTable(
            name = "rel_tarefa_usuario",
            joinColumns = { @JoinColumn(name = "id_tarefa") },
            inverseJoinColumns = { @JoinColumn(name = "id_usuario") }
    )
    private List<Usuario> acompanhadores = new ArrayList<>();

    @Column(name = "id_st_tarefa")
    private Long idStatus;

}
