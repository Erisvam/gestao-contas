package br.com.gestao.contas.login.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.gestao.contas.login.entity.UserLogin;

@Service
public class TokenService {

	@Value("{api.security.token.secret}")
	private String secret;

	public String gerarToken(UserLogin login) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.create()
					.withIssuer("gestao-contas")
					.withSubject(login.getLogin())
					.withClaim("id", String.valueOf(login.getId()))
					.withExpiresAt(dataExpiracao())
					.sign(algorithm);
		} catch (JWTCreationException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Erro ao gerar token JWT");
		}
	}

	public String validarTokenJWT(String tokenJWT) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm).withIssuer("gestao-contas").build().verify(tokenJWT).getSubject();
		} catch (JWTVerificationException exception) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Token JWT inválido ou expirado!");
		}
	}

	private Instant dataExpiracao() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}
