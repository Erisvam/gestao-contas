package br.com.gestao.contas.cartoes.repository;

import br.com.gestao.contas.cartoes.dto.CartaoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<CartaoDTO, String> {
}
