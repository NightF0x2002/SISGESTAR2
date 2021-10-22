package com.github.nightf0x2002.SISGESTAR2.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EmailDTO implements Serializable {

    private String destinatario;
    private String corpo;
    private String assunto;

}
