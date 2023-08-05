package br.com.gestao.contas.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gestao.contas.login.repository.UserLoginRepository;

@Service
public class AuthorizationService implements UserDetailsService {

	@Autowired
	private UserLoginRepository userLogin;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.userLogin.findByLogin(username);
	}

}
