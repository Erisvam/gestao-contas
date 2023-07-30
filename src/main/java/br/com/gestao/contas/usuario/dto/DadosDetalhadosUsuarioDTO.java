package br.com.gestao.contas.usuario.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.gestao.contas.divida.dto.DividasDetalheUsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DadosDetalhadosUsuarioDTO {


	@JsonIgnore
    @JsonProperty("nome_usuario")
    private String nomeUsuario;

    @JsonProperty("nome_cartao")
    private String nomeCartao;

    @JsonProperty("valor_total_cartao")
    private BigDecimal valorTotalCartao;

    @JsonProperty("dividas")
    private List<DividasDetalheUsuarioDTO> dividas;

    public DadosDetalhadosUsuarioDTO(String nomeUsuario, String nomeCartao, BigDecimal valorTotalCartao){
        this.nomeCartao = nomeCartao;
        this.nomeUsuario = nomeUsuario;
        this.valorTotalCartao = valorTotalCartao;
    }

}