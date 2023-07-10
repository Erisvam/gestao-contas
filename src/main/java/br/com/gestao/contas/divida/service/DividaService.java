package br.com.gestao.contas.divida.service;

import br.com.gestao.contas.cartao.dto.CartaoResponseDTO;
import br.com.gestao.contas.usuario.dto.UsuarioDTO;

import java.util.List;
import java.util.Optional;

public interface DividaService {
    List<UsuarioDTO> buscarDividasUsuarioPorCartao(String codigoCartao);

    Optional<CartaoResponseDTO> buscarValorTotalPorCartao(String codigoCartao);

}
