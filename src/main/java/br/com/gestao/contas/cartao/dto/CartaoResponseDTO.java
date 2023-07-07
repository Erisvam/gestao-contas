package br.com.gestao.contas.cartao.dto;

import br.com.gestao.contas.manager.dto.ManagerDTO;
import br.com.gestao.contas.usuario.dto.UsuarioDTO;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartaoResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -696642698843515755L;

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
}
