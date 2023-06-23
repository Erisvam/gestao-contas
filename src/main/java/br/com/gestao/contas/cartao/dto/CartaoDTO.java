package br.com.gestao.contas.cartao.dto;

import br.com.gestao.contas.cartao.enums.FuncionalidadeEnum;
import br.com.gestao.contas.divida.dto.DividaDTO;
import br.com.gestao.contas.proprietario.dto.ProprietarioDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cartao")
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "codigo")
public class CartaoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8333477950659648790L;

    @Id
    private String codigo;

    @NotEmpty(message = "informe o nome do cartão")
    private String nome;

    @NotEmpty(message = "informe data de fechamento do cartão")
    private String dataFechamento;

    @NotEmpty(message = "informe data de vencimento do cartão")
    private String dataVencimento;

    @NotEmpty(message = "informe a funcionalidade do cartão")
    @Enumerated(EnumType.STRING)
    private FuncionalidadeEnum funcionalidade;

    @OneToMany(mappedBy = "cartao")
    private List<DividaDTO> dividas;

    @ManyToOne
    @JoinColumn(name = "proprietario_codigo", nullable = false)
    private ProprietarioDTO proprietario;
}
