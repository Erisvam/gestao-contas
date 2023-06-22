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

    public static DividaViewModel from(DividaDTO divida){
        return new DividaViewModel()
                .builder()
                .codigo(divida.getCodigo())
                .valor(divida.getValor())
                .dataCompra(divida.getDataCompra())
                .status(divida.getStatus())
                .descricao(divida.getDescricao())
                .cartao(from(divida.getCartao()))
                .pessoa(from(divida.getPessoa()))
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
