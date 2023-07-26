package br.com.gestao.contas.cartao.mapper;

import br.com.gestao.contas.cartao.dto.CartaoDTO;
import br.com.gestao.contas.cartao.dto.CartaoResponseDTO;
import br.com.gestao.contas.cartao.entity.Cartao;

public interface CartaoMapperService {

	Cartao to(CartaoDTO cartao);

	CartaoResponseDTO from(Cartao cartaoSalvo);

}
