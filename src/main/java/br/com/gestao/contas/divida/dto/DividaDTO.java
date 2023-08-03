package br.com.gestao.contas.divida.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.gestao.contas.cartao.dto.CartaoDTO;
import br.com.gestao.contas.usuario.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DividaDTO implements Serializable {
	private static final long serialVersionUID = -8976644255393337217L;
	
	@JsonProperty("valor")
	private BigDecimal valor;
	
	@JsonProperty("descricao")
	private String descricao;
	
	@JsonProperty("data_compra")
	private LocalDate dataCompra;
	
	@JsonProperty("cartao")
	private CartaoDTO cartao;
	
	@JsonProperty("usuario")
	private UsuarioDTO usuario;
}
