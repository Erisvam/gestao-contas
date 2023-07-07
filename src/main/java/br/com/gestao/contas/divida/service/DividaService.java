package br.com.gestao.contas.divida.service;

import br.com.gestao.contas.cartao.dto.CartaoResponseDTO;
import br.com.gestao.contas.usuario.dto.UsuarioDTO;

import java.util.List;

public interface DividaService {
    List<UsuarioDTO> buscarDividasUsuarioPorCartao(String codigoCartao);

    CartaoResponseDTO buscarValorTotalPorCartao(String codigoCartao);
}
