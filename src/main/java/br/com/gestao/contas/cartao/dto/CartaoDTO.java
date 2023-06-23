package br.com.gestao.contas.cartao.dto;

import br.com.gestao.contas.cartao.enums.FuncionalidadeEnum;
import br.com.gestao.contas.divida.dto.DividaDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
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
public class CartaoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8333477950659648790L;

    @Id
    private String codigo;

    private String nome;

    private String dataFechamento;

    private String dataVencimento;

    @Enumerated(EnumType.STRING)
    private FuncionalidadeEnum funcionalidade;

    @OneToMany
    @JoinColumn(name = "cartao_codigo")
    private List<DividaDTO> dividas;
}
