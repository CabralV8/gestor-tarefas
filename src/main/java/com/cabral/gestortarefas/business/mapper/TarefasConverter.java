package com.cabral.gestortarefas.business.mapper;


import com.cabral.gestortarefas.business.records.TarefasDTORecord;
import com.cabral.gestortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "dataEvento", target = "dataEvento")
    @Mapping(source = "dataCriacao", target = "dataCriacao")
    TarefasEntity paraTarefaEntity(TarefasDTORecord tarefasDTO);

    TarefasDTORecord paraTarefaDTO(TarefasEntity tarefasEntity);

    List<TarefasEntity> paraListaTarefasEntity(List<TarefasDTORecord> tarefasDTO);

    List<TarefasDTORecord> paraListaTarefasDTORecord(List<TarefasEntity> tarefasEntity);
}
