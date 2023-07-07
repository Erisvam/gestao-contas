package br.com.gestao.contas.cartao.dto;

import br.com.gestao.contas.divida.dto.DividasDetalheUsuarioDTO;
import br.com.gestao.contas.manager.dto.ManagerDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartaoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -1543362696384614654L;

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
