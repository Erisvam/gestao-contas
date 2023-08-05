package br.com.gestao.contas.login.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.gestao.contas.login.enums.UserLoginRoleEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastrarManagerDTO implements Serializable {

	private static final long serialVersionUID = -613419386352560101L;

	@JsonProperty("login")
	private String login;
	
	@JsonProperty("senha")
	private String senha;
	
	@Enumerated(EnumType.STRING)
	@JsonProperty("role")
	private UserLoginRoleEnum role;

}
