package br.com.gestao.contas.usuario.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.gestao.contas.cartao.dto.ValorTotalCartaoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsultaDividaUsuarioResponseDTO implements Serializable {
	
	private static final long serialVersionUID = -9140740957782878896L;
	
	@JsonProperty("nome_usuario")
	private String nomeUsuario;
	
	@JsonProperty("saldo_devedor")
	private BigDecimal saldoDevedor;
	
	@JsonProperty("dividas_usuario")
	private List<ValorTotalCartaoDTO> dividasUsuario = new ArrayList<ValorTotalCartaoDTO>();
}
