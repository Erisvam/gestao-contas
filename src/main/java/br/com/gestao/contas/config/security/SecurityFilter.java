package br.com.gestao.contas.config.security;

import java.io.IOException;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.gestao.contas.login.repository.UserLoginRepository;
import br.com.gestao.contas.login.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private TokenService tokenService;

	@Autowired
	private UserLoginRepository loginRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String tokenJWT = recuperarToken(request);
		if (Strings.isNotBlank(tokenJWT)) {
			String subject = this.tokenService.validarTokenJWT(tokenJWT);
			UserDetails usuario = loginRepository.findByLogin(subject);

			Authentication authorization = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authorization);
		}
		filterChain.doFilter(request, response);
	}

	private String recuperarToken(HttpServletRequest request) {
		String authorization = request.getHeader("Authorization");
		if (Strings.isNotBlank(authorization)) {
			return authorization.replace("Bearer ", "");
		}
		return null;
	}

}
