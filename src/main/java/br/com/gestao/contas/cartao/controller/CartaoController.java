package br.com.gestao.contas.cartao.controller;

import br.com.gestao.contas.cartao.dto.CartaoDTO;
import br.com.gestao.contas.cartao.service.CartaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    private final CartaoService cartaoService;

    public CartaoController(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }

    @GetMapping
    public ResponseEntity<List<CartaoDTO>> consultarCartoes(){
        return ResponseEntity.ok(this.cartaoService.consultarCartoes());
    }

    @PostMapping
    public ResponseEntity<?> cadastrarCartao(@Valid @RequestBody CartaoDTO cartao){
        URI uri = this.cartaoService.cadastrarCartao(cartao);
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> deletarInquilino(@PathVariable String codigo){
        return this.cartaoService.deletarCartao(codigo);
    }

    @PatchMapping("/{codigo}")
    public ResponseEntity<?> editarCartao(@PathVariable String codigo, @RequestBody CartaoDTO cartao){
        return this.cartaoService.editarCartao(codigo, cartao);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<CartaoDTO> consultarCartao(@PathVariable String codigo){
        return this.cartaoService.consultarCartao(codigo);
    }
}
