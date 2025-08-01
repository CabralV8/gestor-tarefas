package com.cabral.gestortarefas.business.dto;


import java.util.List;

public class UsuarioDTO {

    private String email;
    private String senha;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }



    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}

