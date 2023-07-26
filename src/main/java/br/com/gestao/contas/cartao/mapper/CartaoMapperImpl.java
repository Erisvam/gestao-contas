package br.com.gestao.contas.cartao.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gestao.contas.cartao.dto.CartaoDTO;
import br.com.gestao.contas.cartao.dto.CartaoResponseDTO;
import br.com.gestao.contas.cartao.entity.Cartao;

@Component
public class CartaoMapperImpl implements CartaoMapperService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
    public Cartao to(CartaoDTO cartao) {
        return this.modelMapper.map(cartao, Cartao.class);
    }

    @Override
    public CartaoResponseDTO from(Cartao cartaoSalvo) {
        return this.modelMapper.map(cartaoSalvo, CartaoResponseDTO.class);
    }
}
