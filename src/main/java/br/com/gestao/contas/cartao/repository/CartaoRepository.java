package br.com.gestao.contas.cartao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gestao.contas.cartao.entity.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, String>{

}
