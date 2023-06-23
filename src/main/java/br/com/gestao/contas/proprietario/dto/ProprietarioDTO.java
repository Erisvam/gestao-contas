package br.com.gestao.contas.proprietario.dto;

import br.com.gestao.contas.cartao.dto.CartaoDTO;
import br.com.gestao.contas.inquilino.dto.InquilinoDTO;
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
@Entity(name = "proprietario")
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "codigo")
public class ProprietarioDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 6706610245542173302L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotEmpty(message = "informe nome do proprietário")
    private String nome;

    @OneToMany(mappedBy = "proprietario")
    private List<InquilinoDTO> inquilinos;

    @OneToMany(mappedBy = "proprietario")
    private List<CartaoDTO> cartoes;

}
