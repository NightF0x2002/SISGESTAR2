package com.github.nightf0x2002.SISGESTAR2.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ComentarioDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate data;

}
