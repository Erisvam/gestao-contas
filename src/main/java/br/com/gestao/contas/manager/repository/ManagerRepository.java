package br.com.gestao.contas.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gestao.contas.manager.entity.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long>{

}
