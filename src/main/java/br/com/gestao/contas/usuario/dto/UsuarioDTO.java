package br.com.gestao.contas.usuario.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = -7316883042840604957L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("valor_total")
	private BigDecimal valorTotal;

	public UsuarioDTO(String nome, BigDecimal valorTotal) {
		this.nome = nome;
		this.valorTotal = valorTotal;
	}
}
