package br.com.gestao.contas.cartao.service;

import br.com.gestao.contas.cartao.dto.CartaoResponseDTO;
import br.com.gestao.contas.cartao.entity.Cartao;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface CartaoService {
    Cartao cadastrarCartao(Cartao cartao);

    List<CartaoResponseDTO> listarCartoes();

    HttpStatus deletarCartao(String codigo);

    CartaoResponseDTO consultarCartao(String codigoCartao);
}
