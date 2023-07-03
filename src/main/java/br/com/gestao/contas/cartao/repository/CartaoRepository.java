package br.com.gestao.contas.cartao.repository;

import br.com.gestao.contas.cartao.dto.CartaoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<CartaoDTO, String> {
}
