package br.com.gestao.contas.inquilino.dto;

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
@Entity(name = "inquilino")
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class InquilinoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -7812124365204689341L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nome;

    private String telefone;

    @OneToMany
    @JoinColumn(name = "inquilino_codigo")
    private List<DividaDTO> dividas;
}
