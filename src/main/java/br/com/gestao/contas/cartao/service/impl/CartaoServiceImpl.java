package br.com.gestao.contas.cartao.service.impl;

import br.com.gestao.contas.cartao.dto.CartaoDTO;
import br.com.gestao.contas.cartao.respository.CartaoRepository;
import br.com.gestao.contas.cartao.service.CartaoService;
import br.com.gestao.contas.inquilino.dto.InquilinoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class CartaoServiceImpl implements CartaoService {

    private final CartaoRepository cartaoRepository;

    public CartaoServiceImpl(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }

    @Override
    public List<CartaoDTO> consultarCartoes() {
        return this.cartaoRepository.findAll();
    }

    @Override
    public URI cadastrarCartao(CartaoDTO cartao) {
        CartaoDTO cartaoSalvo = this.cartaoRepository.save(cartao);
        return UriComponentsBuilder.fromPath("/cartoes/{codigo}").buildAndExpand(cartaoSalvo.getCodigo()).toUri();
    }

    @Override
    public ResponseEntity<?> deletarCartao(String codigo) {
        Optional<CartaoDTO> cartao = this.cartaoRepository.findById(codigo);
        if(cartao.isPresent()){
            this.cartaoRepository.delete(cartao.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> editarCartao(String codigo, CartaoDTO cartao) {
        Optional<CartaoDTO> cartaoDTO = this.cartaoRepository.findById(codigo);
        if(cartaoDTO.isPresent()){
            cartaoDTO.get().setNome(cartao.getNome());
            cartaoDTO.get().setDataVencimento(cartao.getDataVencimento());
            cartaoDTO.get().setDataFechamento(cartao.getDataFechamento());
            cartaoDTO.get().setFuncionalidade(cartao.getFuncionalidade());

            CartaoDTO cartaoEditado = this.cartaoRepository.save(cartaoDTO.get());
            return ResponseEntity.ok(cartaoEditado);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<CartaoDTO> consultarCartao(String codigo) {
        Optional<CartaoDTO> cartao = this.cartaoRepository.findById(codigo);
        return cartao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
