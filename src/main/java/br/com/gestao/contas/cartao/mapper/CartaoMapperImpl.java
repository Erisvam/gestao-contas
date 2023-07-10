package br.com.gestao.contas.cartao.mapper;

import br.com.gestao.contas.cartao.dto.CartaoDTO;
import br.com.gestao.contas.cartao.dto.CartaoResponseDTO;
import br.com.gestao.contas.cartao.entity.Cartao;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CartaoMapperImpl implements CartaoMapper {

    private final ModelMapper modelMapper;

    @Override
    public Cartao to(CartaoDTO cartao) {
        return this.modelMapper.map(cartao, Cartao.class);
    }

    @Override
    public CartaoResponseDTO from(Cartao cartaoSalvo) {
        return this.modelMapper.map(cartaoSalvo, CartaoResponseDTO.class);
    }
}
