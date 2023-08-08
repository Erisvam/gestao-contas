package br.com.gestao.contas.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.gestao.contas.login.entity.UserLogin;

@Repository
public interface LoginRepository extends JpaRepository<UserLogin, Long>{

	UserDetails findByLogin(String login);
}
