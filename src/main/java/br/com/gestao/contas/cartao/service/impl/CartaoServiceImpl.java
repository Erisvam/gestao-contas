package br.com.gestao.contas.cartao.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.gestao.contas.cartao.dto.CartaoResponseDTO;
import br.com.gestao.contas.cartao.dto.ListaCartoesDTO;
import br.com.gestao.contas.cartao.entity.Cartao;
import br.com.gestao.contas.cartao.mapper.CartaoMapperService;
import br.com.gestao.contas.cartao.repository.CartaoRepository;
import br.com.gestao.contas.cartao.service.CartaoService;
import br.com.gestao.contas.divida.service.DividaService;
import br.com.gestao.contas.usuario.dto.UsuarioDTO;

@Service
public class CartaoServiceImpl implements CartaoService {

	@Autowired
	private CartaoRepository cartaoRepository;

	@Autowired
	private DividaService dividaService;

	@Autowired
	private CartaoMapperService cartaoMapper;

	@Override
	public Cartao cadastrarCartao(Cartao cartao) {
		return this.cartaoRepository.save(cartao);
	}

	@Override
	public ListaCartoesDTO listarCartoes() {
		List<CartaoResponseDTO> listaCartoes = new ArrayList<>();
		this.cartaoRepository.findAll()
			.stream()
			.map(this.cartaoMapper::from)
			.map(cartao -> {
				Optional<CartaoResponseDTO> valorTotalCartaoOptional = this.dividaService.getValorTotalCartao(cartao.getCodigo());
				cartao.setValorTotal(valorTotalCartaoOptional.isPresent() ? valorTotalCartaoOptional.get().getValorTotal() : BigDecimal.ZERO);
				return cartao;
			})
			.sorted(Comparator.comparing(cartao -> ((CartaoResponseDTO) cartao).getValorTotal()).reversed())
			.forEach(cartao -> listaCartoes.add(cartao));
		return new ListaCartoesDTO(listaCartoes);
	}

	@Override
	public HttpStatus deletarCartao(String codigo) {
		Optional<Cartao> cartaoOptional = this.cartaoRepository.findById(codigo);
		if (cartaoOptional.isPresent()) {
			this.cartaoRepository.delete(cartaoOptional.get());
			return HttpStatus.NO_CONTENT;
		}
		return HttpStatus.NOT_FOUND;
	}

	@Override
	public CartaoResponseDTO consultarCartao(String codigoCartao) {
		Optional<Cartao> cartaoOptional = this.cartaoRepository.findById(codigoCartao);
		if (cartaoOptional.isPresent()) {
			CartaoResponseDTO cartaoResponseDTO = this.cartaoMapper.from(cartaoOptional.get());

			List<UsuarioDTO> listaDividasUsuario = this.dividaService.getDividasUsuario(codigoCartao);
			Optional<CartaoResponseDTO> valorTotalCartao = this.dividaService.getValorTotalCartao(codigoCartao);

			cartaoResponseDTO.setUsuarios(listaDividasUsuario);
			cartaoResponseDTO.setValorTotal(valorTotalCartao.isPresent() ? valorTotalCartao.get().getValorTotal() : BigDecimal.ZERO);

			return cartaoResponseDTO;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "cartão não encontrado");
	}
}
