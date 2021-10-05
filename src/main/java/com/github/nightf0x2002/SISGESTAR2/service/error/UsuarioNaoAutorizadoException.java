package com.github.nightf0x2002.SISGESTAR2.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.UNAUTHORIZED,
        reason = "O usuário não tem permissão de realizar essa ação"
)
public class UsuarioNaoAutorizadoException extends RuntimeException {
}
