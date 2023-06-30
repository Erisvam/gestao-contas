package br.com.gestao.contas.usuarios.dto;

import br.com.gestao.contas.manager.dto.ManagerDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UsuarioDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String nome;

    @Column(length = 15)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    private ManagerDTO manager;
}
