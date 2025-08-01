package com.cabral.gestortarefas.infrastructure.entity;

import com.cabral.gestortarefas.infrastructure.enums.StatusNotificacaoEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("tarefa")
public class TarefasEntity {

    @Id
    private String id;
    private String nomeTarefa;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataEvento;
    private String emailUsuario;
    private LocalDateTime dataAlteracao;
    private StatusNotificacaoEnum statusNotificacaoEnum;

    public TarefasEntity() {
    }

    public TarefasEntity(String id, String nomeTarefa, LocalDateTime dataCriacao, LocalDateTime dataEvento, String emailUsuario, LocalDateTime dataAlteracao, StatusNotificacaoEnum statusNotificacaoEnum) {
        this.id = id;
        this.nomeTarefa = nomeTarefa;
        this.dataCriacao = dataCriacao;
        this.dataEvento = dataEvento;
        this.emailUsuario = emailUsuario;
        this.dataAlteracao = dataAlteracao;
        this.statusNotificacaoEnum = statusNotificacaoEnum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDateTime dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public StatusNotificacaoEnum getStatusNotificacaoEnum() {
        return statusNotificacaoEnum;
    }

    public void setStatusNotificacaoEnum(StatusNotificacaoEnum statusNotificacaoEnum) {
        this.statusNotificacaoEnum = statusNotificacaoEnum;
    }
}
