package br.com.gestao.contas.manager.respository;

import br.com.gestao.contas.manager.dto.ManagerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<ManagerDTO, Long> {
}
