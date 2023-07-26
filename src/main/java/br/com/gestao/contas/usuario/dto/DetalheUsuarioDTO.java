package br.com.gestao.contas.usuario.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.gestao.contas.cartao.dto.CartaoDTO;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetalheUsuarioDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -3288842254883266670L;

    @JsonProperty("nome_usuario")
    private String nomeUsuario;

    @JsonProperty("cartoes")
    private List<CartaoDTO> cartoes;
}