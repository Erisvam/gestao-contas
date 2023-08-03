package br.com.gestao.contas.cartao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.gestao.contas.divida.dto.DividasDetalheUsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValorTotalCartaoDTO implements Serializable {
	
	private static final long serialVersionUID = 745463328302987460L;
	
	@JsonProperty("nome_cartao")
	private String nome;
	
	@JsonProperty("valor_total")
	private BigDecimal valor_total;
	
	@JsonProperty("dividas_usuario")
	private List<DividasDetalheUsuarioDTO> dividas;

	public ValorTotalCartaoDTO(String nome, BigDecimal valor_total) {
		this.nome = nome;
		this.valor_total = valor_total;
	}
	
}
