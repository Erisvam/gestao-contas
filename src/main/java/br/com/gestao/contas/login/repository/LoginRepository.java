package br.com.gestao.contas.login.repository;

import br.com.gestao.contas.login.dto.LoginDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoginRepository extends JpaRepository<LoginDto, UUID> {
    UserDetails findByLogin(String login);
}
