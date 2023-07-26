package br.com.gestao.contas.cartao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestao.contas.cartao.dto.CartaoDTO;
import br.com.gestao.contas.cartao.dto.CartaoResponseDTO;
import br.com.gestao.contas.cartao.entity.Cartao;
import br.com.gestao.contas.cartao.mapper.CartaoMapperService;
import br.com.gestao.contas.cartao.service.CartaoService;

@RestController
@RequestMapping("/cartoes")
@CrossOrigin(originPatterns = "*")
public class CartaoController {
	
	@Autowired
	private CartaoService cartaoService;

	@Autowired
    private CartaoMapperService cartaoMapper;

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
