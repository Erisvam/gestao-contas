package br.com.gestao.contas.config;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensagemErro implements Serializable {
	
	private static final long serialVersionUID = 7050085832577473088L;

	private String mensagem;

}
