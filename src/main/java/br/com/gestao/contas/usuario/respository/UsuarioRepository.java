package br.com.gestao.contas.usuario.respository;

import br.com.gestao.contas.usuario.dto.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioDTO, Long> {
}
