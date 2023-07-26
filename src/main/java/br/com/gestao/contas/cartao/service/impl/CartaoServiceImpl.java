package br.com.gestao.contas.cartao.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.gestao.contas.cartao.dto.CartaoResponseDTO;
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
	public List<CartaoResponseDTO> listarCartoes() {
		List<CartaoResponseDTO> cartoesResponse = new ArrayList<>();
		this.cartaoRepository.findAll().stream().map(this.cartaoMapper::from).forEach(from -> {
			Optional<CartaoResponseDTO> cartaoResponseDTO = this.dividaService
					.buscarValorTotalPorCartao(from.getCodigo());
			from.setValorTotal(
					cartaoResponseDTO.isPresent() ? cartaoResponseDTO.get().getValorTotal() : BigDecimal.ZERO);
			cartoesResponse.add(from);
		});
		return cartoesResponse;
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
			CartaoResponseDTO cartaoResponesDTO = this.cartaoMapper.from(cartaoOptional.get());

			List<UsuarioDTO> dividaUsuarioPorCartaoDTOS = this.dividaService.buscarDividasUsuarioPorCartao(codigoCartao);
			Optional<CartaoResponseDTO> valorTotalCartao = this.dividaService.buscarValorTotalPorCartao(codigoCartao);

			cartaoResponesDTO.setUsuarios(dividaUsuarioPorCartaoDTOS);
			cartaoResponesDTO.setValorTotal(
					valorTotalCartao.isPresent() ? valorTotalCartao.get().getValorTotal() : BigDecimal.ZERO);

			return cartaoResponesDTO;
		}
		throw new RuntimeException();
	}
}
