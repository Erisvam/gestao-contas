package br.com.gestao.contas.cartao.respository;

import br.com.gestao.contas.cartao.dto.CartaoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<CartaoDTO, String> {
}
