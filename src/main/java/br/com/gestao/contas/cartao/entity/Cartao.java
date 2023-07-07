package br.com.gestao.contas.cartao.entity;

import br.com.gestao.contas.divida.entity.Divida;
import br.com.gestao.contas.manager.entity.Manager;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_cartoes")
public class Cartao {

    @Id
    private String codigo;

    @Column(nullable = false, length = 25)
    private String nome;

    @JsonProperty("data_fechamento")
    @Column(nullable = false, length = 10)
    private String dataFechamento;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Manager manager;

    @OneToMany(mappedBy = "cartao", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Divida> dividas;
}
