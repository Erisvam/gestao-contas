package br.com.gestao.contas.cartao.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.gestao.contas.divida.dto.DividasDetalheUsuarioDTO;
import br.com.gestao.contas.manager.dto.ManagerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartaoDTO implements Serializable {

	private static final long serialVersionUID = 7322932020857142360L;
	
	@JsonProperty("codigo")
    private String codigo;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("data_fechamento")
    private String dataFechamento;

    @JsonProperty("manager")
    private ManagerDTO manager;

    @JsonProperty("dividas")
    private List<DividasDetalheUsuarioDTO> dividas;

}
