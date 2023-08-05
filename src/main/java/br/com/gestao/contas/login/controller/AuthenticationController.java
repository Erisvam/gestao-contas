package br.com.gestao.contas.login.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestao.contas.config.MensagemErro;
import br.com.gestao.contas.login.dto.AuthenticationDTO;
import br.com.gestao.contas.login.dto.CadastrarManagerDTO;
import br.com.gestao.contas.login.dto.DadosTokenJWT;
import br.com.gestao.contas.login.entity.UserLogin;
import br.com.gestao.contas.login.repository.UserLoginRepository;
import br.com.gestao.contas.login.service.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserLoginRepository userLoginRespository;
	
	@Autowired
	private TokenService tokenService;
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationDTO authenticationDTO){
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authenticationDTO.getLogin(), authenticationDTO.getSenha());
		Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		String tokenJTW = this.tokenService.gerarToken((UserLogin) authenticate.getPrincipal());
		return ResponseEntity.ok(new DadosTokenJWT(tokenJTW));
	}
	
	@PostMapping("/cadastro-manage")
	public ResponseEntity<?> cadastrarManager(@RequestBody CadastrarManagerDTO manager){
		if(Objects.nonNull(this.userLoginRespository.findByLogin(manager.getLogin()))) {
			return ResponseEntity.badRequest().body(new MensagemErro("usuário já cadastrado"));
		}
		String criptografarSenha = new BCryptPasswordEncoder().encode(manager.getSenha());
		UserLogin userLogin = new UserLogin(manager.getLogin(), manager.getRole(), criptografarSenha);
		this.userLoginRespository.save(userLogin);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
