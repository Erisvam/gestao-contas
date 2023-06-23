package br.com.gestao.contas.proprietario.dto;

import br.com.gestao.contas.cartao.dto.CartaoDTO;
import br.com.gestao.contas.inquilino.dto.InquilinoDTO;
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
@Entity(name = "proprietario")
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProprietarioDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 6706610245542173302L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nome;

    @OneToMany
    @JoinColumn(name = "proprietario_codigo")
    private List<InquilinoDTO> inquilinos;

    @OneToMany
    @JoinColumn(name = "proprietario_codigo")
    private List<CartaoDTO> cartoes;

}
