package br.com.gestao.contas.proprietario.repository;

import br.com.gestao.contas.proprietario.dto.ProprietarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProprietarioRespository extends JpaRepository<ProprietarioDTO, Long> {
}
