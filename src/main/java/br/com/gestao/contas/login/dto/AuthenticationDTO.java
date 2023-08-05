package br.com.gestao.contas.login.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationDTO implements Serializable {
	
	private static final long serialVersionUID = -8413869274620960410L;

	@JsonProperty("login")
	private String login;
	
	@JsonProperty("senha")
	private String senha;
}
