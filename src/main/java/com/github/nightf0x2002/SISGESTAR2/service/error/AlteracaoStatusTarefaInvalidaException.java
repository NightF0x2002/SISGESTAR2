package com.github.nightf0x2002.SISGESTAR2.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,
                reason = "A alteração de status é inválida.")
public class AlteracaoStatusTarefaInvalidaException extends RuntimeException {
}
