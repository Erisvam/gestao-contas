package br.com.gestao.contas.cartao.dto;

import br.com.gestao.contas.manager.dto.ManagerDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cartao")
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -1572261752842862347L;

    @Id
    private String codigo;

    @Column(length = 40, nullable = false, unique = true)
    private String nome;

    @Column(length = 6, nullable = false)
    private String dataFechamento;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    private ManagerDTO manager;

    @JsonProperty("valor_total")
    private BigDecimal valorTotal;
}
