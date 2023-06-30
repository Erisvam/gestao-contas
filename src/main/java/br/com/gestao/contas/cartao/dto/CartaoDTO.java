package br.com.gestao.contas.cartao.dto;

import br.com.gestao.contas.manager.dto.ManagerDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cartao")
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CartaoDTO implements Serializable {

    @Id
    private String codigo;

    @Column(length = 40, nullable = false, unique = true)
    private String nome;

    @Column(length = 6, nullable = false)
    private String dataFechamento;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private ManagerDTO manager;
}
