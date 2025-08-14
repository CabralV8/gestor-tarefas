package com.cabral.gestortarefas.infrastructure.security;


import com.cabral.gestortarefas.business.records.UsuarioDTORecord;
import com.cabral.gestortarefas.infrastructure.client.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

    @Autowired
    private UsuarioClient usuarioClient;

    public UserDetails carregaDadosUsuario(String email, String token){

        UsuarioDTORecord usuarioDTORecord = usuarioClient.buscarUsuarioPorEmail(email, token);

        return User
                .withUsername(usuarioDTORecord.email()) // usando o record
                .password(usuarioDTORecord.senha())     // usando o record
                .build();
    }
}
