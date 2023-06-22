package br.com.gestao.contas.cartoes.controller;

import br.com.gestao.contas.cartoes.dto.CartaoDTO;
import br.com.gestao.contas.cartoes.repository.CartaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/cartoes")
public class CartoesController {

    private final CartaoRepository cartaoRepository;

    public CartoesController(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarCartao(@RequestBody CartaoDTO cartao){
        CartaoDTO cartaoSalvo = this.cartaoRepository.save(cartao);

        URI uri = UriComponentsBuilder.fromPath("/cartoes/{codigo}").buildAndExpand(cartao.getCodigo()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("{codigo}")
    public ResponseEntity<CartaoDTO> consultarCartao(@PathVariable String codigo){
        Optional<CartaoDTO> cartao = this.cartaoRepository.findById(codigo);
        return cartao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
