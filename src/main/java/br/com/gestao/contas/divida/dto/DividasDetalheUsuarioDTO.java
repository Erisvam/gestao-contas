package br.com.gestao.contas.divida.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
public class DividasDetalheUsuarioDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 9113677797177971627L;

    @JsonProperty("codigo_cartao")
    private String codigoCartao;

    @JsonProperty("nome_banco")
    private String nomeBanco;

    @JsonProperty("valor_compra")
    private BigDecimal valorCompra;

    @JsonProperty("data_compra")
    private LocalDate dataCompra;

    @JsonProperty("descricao_compra")
    private String descricaoCompra;

    public DividasDetalheUsuarioDTO(String codigoCartao ,String nomeBanco, BigDecimal valorCompra, LocalDate dataCompra, String descricaoCompra){
        this.codigoCartao = codigoCartao;
        this.nomeBanco = nomeBanco;
        this.dataCompra = dataCompra;
        this.valorCompra = valorCompra;
        this.descricaoCompra = descricaoCompra;
    }
}
