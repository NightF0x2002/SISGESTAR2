package com.github.nightf0x2002.SISGESTAR2.service.mapper;

public interface EntityMapper<ENTIDADE, DTO> {

    DTO toDTO(ENTIDADE entidade);

    ENTIDADE toEntity(DTO dto);

}
