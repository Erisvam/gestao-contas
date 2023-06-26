package br.com.gestao.contas.login.controller;

import br.com.gestao.contas.infra.security.TokenService;
import br.com.gestao.contas.infra.security.dto.DadosTokenJWT;
import br.com.gestao.contas.login.dto.LoginDto;
import br.com.gestao.contas.login.viewmodel.DadosAutenticacaoViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    ResponseEntity<?> efetuarLogin(@RequestBody DadosAutenticacaoViewModel dadosAutenticacao){
        Authentication token = new UsernamePasswordAuthenticationToken(dadosAutenticacao.getLogin(), dadosAutenticacao.getSenha());
        Authentication authenticate = this.manager.authenticate(token);

        String tokenJTW = this.tokenService.gerarToken((LoginDto) authenticate.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJTW));
    }
}
