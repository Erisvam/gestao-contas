package br.com.gestao.contas.cartao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.gestao.contas.manager.dto.ManagerDTO;
import br.com.gestao.contas.usuario.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartaoResponseDTO implements Serializable {

	private static final long serialVersionUID = -1547753614114479502L;
	
    @JsonProperty("codigo")
    private String codigo;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("data_fechamento")
    private String dataFechamento;

    @JsonProperty("manager")
    private ManagerDTO manager;

    @JsonProperty("valor_total")
    private BigDecimal valorTotal;

    @JsonProperty("usuarios")
    private List<UsuarioDTO> usuarios;
    
    public CartaoResponseDTO(String nomeCartao, BigDecimal valorTotal){
        this.nome = nomeCartao;
        this.valorTotal = valorTotal;
    }

    public CartaoResponseDTO(String codigoCartao, String nomeCartao, BigDecimal valorTotal){
        this.codigo = codigoCartao;
        this.nome = nomeCartao;
        this.valorTotal = valorTotal;
    }

}
