package br.com.gestao.contas.dividas.mapper;

import br.com.gestao.contas.cartoes.dto.CartaoDTO;
import br.com.gestao.contas.dividas.dto.DividaDTO;
import br.com.gestao.contas.dividas.viewmodel.CartaoViewModel;
import br.com.gestao.contas.dividas.viewmodel.DividaViewModel;
import br.com.gestao.contas.dividas.viewmodel.PessoaViewModel;
import br.com.gestao.contas.pessoas.dto.PessoaDTO;

import java.util.Optional;

public class DividaMapper {

    private DividaMapper(){}

    public static DividaViewModel from(Optional<DividaDTO> divida){
        DividaDTO dividaDTO = divida.get();
        return new DividaViewModel()
                .builder()
                .valor(dividaDTO.getValor())
                .dataCompra(dividaDTO.getDataCompra())
                .status(dividaDTO.getStatus())
                .descricao(dividaDTO.getDescricao())
                .cartao(from(dividaDTO.getCartao()))
                .pessoa(from(dividaDTO.getPessoa()))
                .build();
    }

    private static PessoaViewModel from(PessoaDTO pessoa) {
        return PessoaViewModel
                .builder()
                .nome(pessoa.getNome())
                .build();
    }

    private static CartaoViewModel from(CartaoDTO cartaoDTO){
        return new CartaoViewModel()
                .builder()
                .nome(cartaoDTO.getNome())
                .funcionalidade(cartaoDTO.getFuncionalidade())
                .build();
    }
}
