package br.com.gestao.contas.dividas.dto;

import br.com.gestao.contas.cartoes.dto.CartaoDTO;
import br.com.gestao.contas.pessoas.dto.PessoaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "dividas")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DividaDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private BigDecimal valor;

    private LocalDate dataCompra;

    private String descricao;

    private String status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cartoes_codigo")
    private CartaoDTO cartao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pessoas_codigo")
    private PessoaDTO pessoa;
}
