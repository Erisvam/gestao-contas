package br.com.gestao.contas.dividas.viewmodel;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DividaViewModel {

    private BigDecimal valor;

    private LocalDate dataCompra;

    private String descricao;

    private String status;

    private CartaoViewModel cartao;

    private PessoaViewModel pessoa;
}
