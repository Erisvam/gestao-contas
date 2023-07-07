package br.com.gestao.contas.manager.entity;

import br.com.gestao.contas.cartao.entity.Cartao;
import br.com.gestao.contas.usuario.entity.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_managers")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String nome;

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Cartao> cartoes;

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Usuario> usuarios;
}
