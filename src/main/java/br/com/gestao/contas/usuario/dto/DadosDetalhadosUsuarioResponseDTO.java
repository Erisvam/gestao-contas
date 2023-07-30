package br.com.gestao.contas.usuario.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DadosDetalhadosUsuarioResponseDTO implements Serializable {

	private static final long serialVersionUID = 7154452621032076967L;
	
	@JsonProperty("nome_usuario")
    private String nomeUsuario;
	 
	@JsonProperty("saldo_devedor")
	private BigDecimal saldoDevedor;
	
	@JsonProperty("dividas_usuario")
	private List<DadosDetalhadosUsuarioDTO> dividasUsuario;
}
