package com.cabral.gestortarefas.business.mapper;

import com.cabral.gestortarefas.business.dto.TarefasDTO;
import com.cabral.gestortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO tarefasDTO);

    TarefasDTO paraTarefaDTO(TarefasEntity tarefasEntity);
}
