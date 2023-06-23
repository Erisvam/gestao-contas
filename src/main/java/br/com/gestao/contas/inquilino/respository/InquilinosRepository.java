package br.com.gestao.contas.inquilino.respository;

import br.com.gestao.contas.inquilino.dto.InquilinoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquilinosRepository extends JpaRepository<InquilinoDTO, Long> {

}
