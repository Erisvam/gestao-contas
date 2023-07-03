package br.com.gestao.contas.cartao.controller;

import br.com.gestao.contas.cartao.dto.CartaoDTO;
import br.com.gestao.contas.cartao.repository.CartaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartoes")
@CrossOrigin(originPatterns = "*")
public class CartaoController {

    private final CartaoRepository cartaoRepository;

    public CartaoController(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }

    @PostMapping
    public ResponseEntity<CartaoDTO> cadastrarCartao(@RequestBody CartaoDTO cartaoDTO){
        return ResponseEntity.ok(this.cartaoRepository.save(cartaoDTO));
    }

    @GetMapping
    public ResponseEntity<List<CartaoDTO>> listarCartoes(){
        return ResponseEntity.ok(this.cartaoRepository.findAll());
    }

}
