package br.com.gestao.contas.cartao.repository;

import br.com.gestao.contas.cartao.entity.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, String> {
}
