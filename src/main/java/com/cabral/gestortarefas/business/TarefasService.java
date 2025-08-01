package com.cabral.gestortarefas.business;

import com.cabral.gestortarefas.business.dto.TarefasDTO;
import com.cabral.gestortarefas.business.mapper.TarefasConverter;
import com.cabral.gestortarefas.infrastructure.entity.TarefasEntity;
import com.cabral.gestortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.cabral.gestortarefas.infrastructure.repository.TarefasRepository;
import com.cabral.gestortarefas.infrastructure.security.JwtUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    public TarefasService(TarefasRepository tarefasRepository, TarefasConverter tarefasConverter,JwtUtil jwtUtil) {
        this.tarefasRepository = tarefasRepository;
        this.tarefasConverter = tarefasConverter;
        this.jwtUtil = jwtUtil;
    }

    public TarefasDTO gravarTarefa(String token,TarefasDTO dto){
        String email = jwtUtil.extractEmailToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefasConverter.paraTarefaEntity(dto);

        return tarefasConverter.paraTarefaDTO(
                tarefasRepository.save(entity));
    }
}
