package com.github.nightf0x2002.SISGESTAR2.domain.enumarations;

import com.github.nightf0x2002.SISGESTAR2.service.error.AlteracaoStatusTarefaInvalidaException;
import com.github.nightf0x2002.SISGESTAR2.service.error.StatusInexistenteException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;


@Getter
@AllArgsConstructor
public enum StatusTarefaEnum {

    A_FAZER(1L, "A Fazer") {
        @Override
        public void validarProximoStatus(StatusTarefaEnum proximoStatus) {
            if (!proximoStatus.equals(FAZENDO)) {
                throw new AlteracaoStatusTarefaInvalidaException();
            }
        }
    },
    FAZENDO(2L, "Fazendo") {
        @Override
        public void validarProximoStatus(StatusTarefaEnum proximoStatus) {
            if (!proximoStatus.equals(FAZENDO)) {
                throw new AlteracaoStatusTarefaInvalidaException();
            }
        }
    },
    PAUSADA(3L, "Pausada") {
        @Override
        public void validarProximoStatus(StatusTarefaEnum proximoStatus) {
            if (!proximoStatus.equals(FAZENDO)) {
                throw new AlteracaoStatusTarefaInvalidaException();
            }
        }
    },

    FEITO(4L, "Feito") {
        @Override
        public void validarProximoStatus(StatusTarefaEnum proximoStatus) {
            if (!proximoStatus.equals(FAZENDO)) {
                throw new AlteracaoStatusTarefaInvalidaException();
            }
        }
    };

    private Long id;
    private String descricao;

    public abstract void validarProximoStatus(StatusTarefaEnum proximoStatus);

    public static StatusTarefaEnum obterPorId(Long id) {
        return Arrays.stream(StatusTarefaEnum.values())
                .filter(enumeration -> id.equals(enumeration.getId()))
                .findFirst().orElseThrow(StatusInexistenteException::new);
    }
}
