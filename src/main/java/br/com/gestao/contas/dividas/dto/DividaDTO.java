package br.com.gestao.contas.dividas.dto;

import br.com.gestao.contas.cartoes.dto.CartaoDTO;
import br.com.gestao.contas.pessoas.dto.PessoaDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "codigo")
public class DividaDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -2408006229305413546L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private BigDecimal valor;

    private LocalDate dataCompra;

    private String descricao;

    private String status;

    @ManyToOne
    @JoinColumn(name = "cartoes_codigo")
    @JsonBackReference
    private CartaoDTO cartao;

    @ManyToOne
    @JoinColumn(name = "pessoas_codigo")
    @JsonBackReference
    private PessoaDTO pessoa;
}
