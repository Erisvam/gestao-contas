package br.com.gestao.contas.divida.dto;

import br.com.gestao.contas.cartao.dto.CartaoDTO;
import br.com.gestao.contas.usuario.dto.UsuarioDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "divida")
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DividaDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDate dataCompra;

    @ManyToOne
    @JoinColumn(name = "cartao_codigo", nullable = false)
    private CartaoDTO cartao;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioDTO usuario;

}
