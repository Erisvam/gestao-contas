package br.com.gestao.contas.usuario.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.gestao.contas.cartao.dto.ValorTotalCartaoDTO;
import br.com.gestao.contas.divida.repository.DividaRepository;
import br.com.gestao.contas.usuario.dto.ConsultaDividaUsuarioResponseDTO;
import br.com.gestao.contas.usuario.dto.ListaUsuariosDTO;
import br.com.gestao.contas.usuario.dto.UsuarioDTO;
import br.com.gestao.contas.usuario.entity.Usuario;
import br.com.gestao.contas.usuario.mapper.UsuarioMapper;
import br.com.gestao.contas.usuario.repository.UsuarioRepository;
import br.com.gestao.contas.usuario.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private DividaRepository dividaRepository;
	
	@Autowired
	private UsuarioMapper usuarioMapper;

	@Override
	public ConsultaDividaUsuarioResponseDTO consultarDividaUsuario(Long id) {
		Optional<Usuario> usuarioOptional = this.usuarioRepository.findById(id);
		if (usuarioOptional.isPresent()) {
			List<ValorTotalCartaoDTO> listaCartoes = this.dividaRepository.getValorTotalByCartao(usuarioOptional.get().getNome());
			listaCartoes.forEach(cartao -> cartao.setDividas(this.dividaRepository.getDetalhesDasComprasByUsuarioECartao(usuarioOptional.get().getNome(), cartao.getNome())));
			return new ConsultaDividaUsuarioResponseDTO(usuarioOptional.get().getNome(), getSaldoDevedor(listaCartoes), listaCartoes);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "usuário não encontrado");
	}

	private BigDecimal getSaldoDevedor(List<ValorTotalCartaoDTO> listaCartoes) {
		return listaCartoes
			.stream()
			.map(cartao -> cartao.getValor_total())
			.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	@Override
	public ListaUsuariosDTO listarUsuarios() {
		List<UsuarioDTO> listaUsuarios = new ArrayList<>();
		this.usuarioRepository.findAll()
			.stream()
			.map(this.usuarioMapper::from)
			.map(usuario -> {
				Optional<UsuarioDTO> dividaUsuarioOptional = this.dividaRepository.getDividaTotalUsuario(usuario.getId());
				usuario.setValorTotal(dividaUsuarioOptional.isPresent() ? dividaUsuarioOptional.get().getValorTotal() : BigDecimal.ZERO);
				return usuario;
			})
			.forEach(listaUsuarios::add);
		return new ListaUsuariosDTO(listaUsuarios);
	}
}