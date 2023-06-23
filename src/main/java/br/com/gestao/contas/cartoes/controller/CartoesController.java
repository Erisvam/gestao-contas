package br.com.gestao.contas.cartoes.controller;

import br.com.gestao.contas.cartoes.dto.CartaoDTO;
import br.com.gestao.contas.cartoes.repository.CartaoRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
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

        URI uri = UriComponentsBuilder.fromPath("/cartoes/{codigo}").buildAndExpand(cartaoSalvo.getCodigo()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<CartaoDTO> consultarCartao(@PathVariable String codigo){
        Optional<CartaoDTO> cartao = this.cartaoRepository.findById(codigo);
        return cartao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<CartaoDTO> alterarCartao(@PathVariable String codigo, @RequestBody CartaoDTO cartao){
        Optional<CartaoDTO> cartaoDTO = this.cartaoRepository.findById(codigo);
        if(cartaoDTO.isPresent()){
            cartaoDTO.get().setNome(cartao.getNome());
            cartaoDTO.get().setDataFechamento(cartao.getDataFechamento());
            cartaoDTO.get().setDataVencimento(cartao.getDataVencimento());
            cartaoDTO.get().setFuncionalidade(cartao.getFuncionalidade());

            CartaoDTO cartaoAlterado = this.cartaoRepository.save(cartaoDTO.get());
            return ResponseEntity.ok(cartaoAlterado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> deletarCartao(@PathVariable String codigo){
        Optional<CartaoDTO> cartao = this.cartaoRepository.findById(codigo);
        if(cartao.isPresent()){
            this.cartaoRepository.delete(cartao.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<CartaoDTO>> consultarCartoes(){
        List<CartaoDTO> cartoes = this.cartaoRepository.findAll();
        return ResponseEntity.ok(cartoes);
    }
}
