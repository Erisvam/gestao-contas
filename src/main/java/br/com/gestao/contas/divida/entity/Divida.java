package br.com.gestao.contas.divida.entity;

import br.com.gestao.contas.cartao.entity.Cartao;
import br.com.gestao.contas.usuario.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_dividas")
public class Divida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal valor;

    @JsonProperty("data_compra")
    @Column(name = "data_compra", nullable = false)
    private LocalDate dataCompra;

    @Column(nullable = false, length = 50)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "cartao_codigo", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cartao cartao;

}
