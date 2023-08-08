package br.com.gestao.contas.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gestao.contas.login.repository.LoginRepository;

@Service
public class LoginService implements UserDetailsService {

	@Autowired
	private LoginRepository userLogin;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.userLogin.findByLogin(username);
	}

}
