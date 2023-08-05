package br.com.gestao.contas.login.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class DadosTokenJWT {

	@JsonProperty("access_token")
	private String accessToken;

    public DadosTokenJWT(String accessToken) {
        this.accessToken = accessToken;
    }
}
