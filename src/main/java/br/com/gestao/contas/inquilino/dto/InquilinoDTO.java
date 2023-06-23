package br.com.gestao.contas.inquilino.dto;

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
@Entity(name = "inquilino")
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "codigo")
public class InquilinoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -7812124365204689341L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotEmpty(message = "informe o nome")
    private String nome;

    private String telefone;

    @ManyToOne
    @JoinColumn(name = "proprietario_codigo", nullable = false)
    private ProprietarioDTO proprietario;

    @OneToMany(mappedBy = "inquilino")
    private List<DividaDTO> dividas;

}
