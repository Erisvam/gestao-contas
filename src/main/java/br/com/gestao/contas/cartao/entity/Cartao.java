package br.com.gestao.contas.cartao.entity;

import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.gestao.contas.divida.entity.Divida;
import br.com.gestao.contas.manager.entity.Manager;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
