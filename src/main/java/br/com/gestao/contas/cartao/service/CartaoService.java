package br.com.gestao.contas.cartao.service;

import br.com.gestao.contas.cartao.dto.CartaoDTO;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

public interface CartaoService {
    List<CartaoDTO> consultarCartoes();

    URI cadastrarCartao(CartaoDTO cartao);

    ResponseEntity<?> deletarCartao(String codigo);

    ResponseEntity<?> editarCartao(String codigo, CartaoDTO cartao);

    ResponseEntity<CartaoDTO> consultarCartao(String codigo);

}
