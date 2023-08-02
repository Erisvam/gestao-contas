package br.com.gestao.contas.cartao.service;

import org.springframework.http.HttpStatus;

import br.com.gestao.contas.cartao.dto.CartaoResponseDTO;
import br.com.gestao.contas.cartao.dto.ListaCartoesDTO;
import br.com.gestao.contas.cartao.entity.Cartao;

public interface CartaoService {

	Cartao cadastrarCartao(Cartao toCartao);

	ListaCartoesDTO listarCartoes();

	HttpStatus deletarCartao(String codigo);

	CartaoResponseDTO consultarCartao(String codigoCartao);

}
