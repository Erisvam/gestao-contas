package br.com.gestao.contas.pessoas.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "pessoas")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PessoaDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -7954343849083592688L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nome;

    private String telefone;
}