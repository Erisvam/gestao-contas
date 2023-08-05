package br.com.gestao.contas.config;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MensagemErro extends RuntimeException implements Serializable {
	
	private static final long serialVersionUID = 7050085832577473088L;

	private String mensagem;

}
