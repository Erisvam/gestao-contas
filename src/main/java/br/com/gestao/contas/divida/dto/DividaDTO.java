package br.com.gestao.contas.divida.dto;

import br.com.gestao.contas.divida.enums.StatusCompraEnum;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
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
public class DividaDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1229038744005756303L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private BigDecimal valor;

    private LocalDate dataCompra;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusCompraEnum status;

}
