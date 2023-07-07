package br.com.gestao.contas.manager.repository;

import br.com.gestao.contas.manager.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
