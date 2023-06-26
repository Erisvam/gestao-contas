package br.com.gestao.contas.infra.security.dto;

import lombok.Getter;

@Getter
public class DadosTokenJWT {

    private String tokenJWT;

    public DadosTokenJWT(String tokenJTW) {
        this.tokenJWT = tokenJTW;
    }
}
