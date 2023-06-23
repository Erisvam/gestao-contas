package br.com.gestao.contas.divida.dto;

import br.com.gestao.contas.cartao.dto.CartaoDTO;
import br.com.gestao.contas.divida.enums.StatusCompraEnum;
import br.com.gestao.contas.inquilino.dto.InquilinoDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "divida")
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "codigo")
public class DividaDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1229038744005756303L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull(message = "informe valor da compra")
    private BigDecimal valor;

    @NotNull(message = "informe a data da compra")
    private LocalDate dataCompra;

    private String descricao;

    @NotNull(message = "informe status da compra")
    @Enumerated(EnumType.STRING)
    private StatusCompraEnum status;

    @ManyToOne
    @JoinColumn(name = "inquilino_codigo", nullable = false)
    private InquilinoDTO inquilino;

    @ManyToOne
    @JoinColumn(name = "cartao_codigo", nullable = false)
    private CartaoDTO cartao;

}
