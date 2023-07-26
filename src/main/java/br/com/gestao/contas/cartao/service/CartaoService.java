package br.com.gestao.contas.cartao.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import br.com.gestao.contas.cartao.dto.CartaoResponseDTO;
import br.com.gestao.contas.cartao.entity.Cartao;

public interface CartaoService {

	Cartao cadastrarCartao(Cartao toCartao);

	List<CartaoResponseDTO> listarCartoes();

	HttpStatus deletarCartao(String codigo);

	CartaoResponseDTO consultarCartao(String codigoCartao);

}
