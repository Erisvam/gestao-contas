package br.com.gestao.contas.cartoes.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cartoes")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CartaoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 206794983077093261L;

    @Id
    private String codigo;

    private String nome;

    private String dataFechamento;

    private String dataVencimento;

    private String funcionalidade;
}
