package br.com.gestao.contas.pessoas.repository;

import br.com.gestao.contas.pessoas.dto.PessoaDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaDTO, Long> {
}
