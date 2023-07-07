package br.com.gestao.contas.usuario.entity;


import br.com.gestao.contas.divida.entity.Divida;
import br.com.gestao.contas.manager.entity.Manager;
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
@Table(name = "tbl_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(length = 20)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Manager manager;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Divida> dividas;
}
