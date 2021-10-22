package com.github.nightf0x2002.SISGESTAR2.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.BAD_REQUEST,
                 reason = "Usuário não encontrado.")
public class UsuarioNaoEncontradoException extends RuntimeException {
}
