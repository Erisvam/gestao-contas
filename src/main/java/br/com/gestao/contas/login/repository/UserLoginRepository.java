package br.com.gestao.contas.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.gestao.contas.login.entity.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long>{

	UserDetails findByLogin(String login);
}
