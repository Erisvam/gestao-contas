package br.com.gestao.contas.cartao.service.impl;

import br.com.gestao.contas.cartao.dto.CartaoResponseDTO;
import br.com.gestao.contas.cartao.entity.Cartao;
import br.com.gestao.contas.cartao.mapper.CartaoMapper;
import br.com.gestao.contas.cartao.repository.CartaoRepository;
import br.com.gestao.contas.cartao.service.CartaoService;
import br.com.gestao.contas.divida.service.DividaService;
import br.com.gestao.contas.usuario.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CartaoServiceImpl implements CartaoService {

    private final CartaoRepository cartaoRepository;

    private final DividaService dividaService;

    private final CartaoMapper cartaoMapper;

    @Override
    public Cartao cadastrarCartao(Cartao cartao) {
        return this.cartaoRepository.save(cartao);
    }

    @Override
    public List<Cartao> listarCartoes() {
        return this.cartaoRepository.findAll();
    }

    @Override
    public HttpStatus deletarCartao(String codigo) {
        Optional<Cartao> cartaoOptional = this.cartaoRepository.findById(codigo);
        if(cartaoOptional.isPresent()){
            this.cartaoRepository.delete(cartaoOptional.get());
            return HttpStatus.NO_CONTENT;
        }
        return HttpStatus.NOT_FOUND;
    }

    @Override
    public CartaoResponseDTO consultarCartao(String codigoCartao) {
        Optional<Cartao> cartaoOptional = this.cartaoRepository.findById(codigoCartao);
        if(cartaoOptional.isPresent()){
            CartaoResponseDTO cartaoResponesDTO = this.cartaoMapper.from(cartaoOptional.get());

            List<UsuarioDTO> dividaUsuarioPorCartaoDTOS = this.dividaService.buscarDividasUsuarioPorCartao(codigoCartao);
            CartaoResponseDTO valorTotalCartao = this.dividaService.buscarValorTotalPorCartao(codigoCartao);

            cartaoResponesDTO.setUsuarios(dividaUsuarioPorCartaoDTOS);
            cartaoResponesDTO.setValorTotal(valorTotalCartao.getValorTotal());

            return cartaoResponesDTO;
        }
        throw new RuntimeException();
    }
}
