package br.com.gestao.contas.cartoes.dto;

import br.com.gestao.contas.dividas.dto.DividaDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cartoes")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "codigo")
public class CartaoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 206794983077093261L;

    @Id
    private String codigo;

    private String nome;

    private String dataFechamento;

    private String dataVencimento;

    private String funcionalidade;

    @OneToMany(mappedBy = "cartao", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DividaDTO> dividas;
}
