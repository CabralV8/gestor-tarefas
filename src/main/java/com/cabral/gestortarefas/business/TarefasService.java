package com.cabral.gestortarefas.business;

import com.cabral.gestortarefas.business.records.TarefasDTORecord;
import com.cabral.gestortarefas.business.mapper.TarefaUpdateConverter;
import com.cabral.gestortarefas.business.mapper.TarefasConverter;
import com.cabral.gestortarefas.infrastructure.entity.TarefasEntity;
import com.cabral.gestortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.cabral.gestortarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.cabral.gestortarefas.infrastructure.repository.TarefasRepository;
import com.cabral.gestortarefas.infrastructure.security.JwtUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;
    private final TarefaUpdateConverter tarefaUpdateConverter;

    public TarefasService(TarefasRepository tarefasRepository, TarefasConverter tarefasConverter, JwtUtil jwtUtil, TarefaUpdateConverter tarefaUpdateConverter) {
        this.tarefasRepository = tarefasRepository;
        this.tarefasConverter = tarefasConverter;
        this.jwtUtil = jwtUtil;
        this.tarefaUpdateConverter = tarefaUpdateConverter;
    }

    public TarefasDTORecord gravarTarefa(String token, TarefasDTORecord dto) {
        String email = jwtUtil.extractEmailToken(token.substring(7));
        TarefasDTORecord dtoFinal = new TarefasDTORecord(null, dto.nomeTarefa(),
                dto.descricao(),
                LocalDateTime.now(), dto.dataEvento(), email, null,
                StatusNotificacaoEnum.PENDENTE);
        TarefasEntity entity = tarefasConverter.paraTarefaEntity(dtoFinal);

        return tarefasConverter.paraTarefaDTO(
                tarefasRepository.save(entity));
    }

    public List<TarefasDTORecord> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal) {

        return tarefasConverter.paraListaTarefasDTORecord(
                tarefasRepository.findByDataEventoBetweenAndStatusNotificacaoEnum(dataInicial, dataFinal,
                        StatusNotificacaoEnum.PENDENTE)
        );
    }

    public List<TarefasDTORecord> buscaTarefasPorEmail(String token) {
        String email = jwtUtil.extractEmailToken(token.substring(7));
        List<TarefasEntity> listaTarefas = tarefasRepository.findByEmailUsuario(email);

        return tarefasConverter.paraListaTarefasDTORecord(listaTarefas);
    }

    public void deletaTarefaPorId(String id) {
        try {
            tarefasRepository.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Erro ao deletar tarefa por id - id inexistente: " + id,
                    e.getCause());
        }
    }

    public TarefasDTORecord alteraStatus(StatusNotificacaoEnum status, String id) {
        try {
            TarefasEntity entity = tarefasRepository.findById(id).
                    orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada " + id));
            entity.setStatusNotificacaoEnum(status);
            return tarefasConverter.paraTarefaDTO(tarefasRepository.save(entity));
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Erro ao alterar status da tarefa " + e.getCause());
        }
    }

    public TarefasDTORecord updateTarefas(TarefasDTORecord dto, String id){
        try {
            TarefasEntity entity = tarefasRepository.findById(id).
                    orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada " + id));
            tarefaUpdateConverter.updateTarefas(dto, entity);
            return tarefasConverter.paraTarefaDTO(tarefasRepository.save(entity));

        }catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Erro ao alterar status da tarefa " + e.getCause());
        }
    }
}


