package br.com.gestao.contas.cartao.controller;

import br.com.gestao.contas.cartao.dto.CartaoDTO;
import br.com.gestao.contas.cartao.dto.CartaoResponseDTO;
import br.com.gestao.contas.cartao.entity.Cartao;
import br.com.gestao.contas.cartao.mapper.CartaoMapper;
import br.com.gestao.contas.cartao.service.CartaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")
public class CartaoController {

    private final CartaoService cartaoService;

    private final CartaoMapper cartaoMapper;

    @PostMapping
    public ResponseEntity<CartaoResponseDTO> cadastrarCartao(@RequestBody CartaoDTO cartao){
        Cartao toCartao = this.cartaoMapper.to(cartao);
        Cartao cartaoSalvo = this.cartaoService.cadastrarCartao(toCartao);
        CartaoResponseDTO cartaoSalvoDto =  this.cartaoMapper.from(cartaoSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartaoSalvoDto);
    }

    @GetMapping
    public ResponseEntity<List<CartaoResponseDTO>> listarCartoes(){
        List<CartaoResponseDTO> cartoes = this.cartaoService.listarCartoes();
        return ResponseEntity.ok(cartoes);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> deletarCartao(@PathVariable String codigo){
        HttpStatus statusCode = this.cartaoService.deletarCartao(codigo);
        return ResponseEntity.status(statusCode).build();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<CartaoResponseDTO> consultarCartao(@PathVariable(value = "codigo") String codigoCartao){
        CartaoResponseDTO cartaoResponseDTO = this.cartaoService.consultarCartao(codigoCartao);
        return ResponseEntity.status(HttpStatus.OK).body(cartaoResponseDTO);
    }
}
