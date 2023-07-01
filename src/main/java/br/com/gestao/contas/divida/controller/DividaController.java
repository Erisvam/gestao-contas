package br.com.gestao.contas.divida.controller;

import br.com.gestao.contas.divida.dto.DividaDTO;
import br.com.gestao.contas.divida.respository.DividaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dividas")

@CrossOrigin(originPatterns = "*")
public class DividaController {

    private final DividaRepository dividaRepository;

    public DividaController(DividaRepository dividaRepository) {
        this.dividaRepository = dividaRepository;
    }

    @PostMapping
    public ResponseEntity<DividaDTO> cadastrarDivida(@RequestBody DividaDTO dividaDTO){
        return ResponseEntity.ok(this.dividaRepository.save(dividaDTO));
    }

    @GetMapping
    public ResponseEntity<List<DividaDTO>> listarDividas(){
        return ResponseEntity.ok(this.dividaRepository.findAll());
    }

    @GetMapping("/cartao/{codigo_cartao}")
    public ResponseEntity<List<DividaDTO>> listarDividasCartao(@PathVariable (name = "codigo_cartao") String codigoCartao){
        List<DividaDTO> dividasCartao = this.dividaRepository.findByCodigoCartao(codigoCartao);
        Optional<BigDecimal> valorTotal = dividasCartao.stream().map(DividaDTO::getValor).reduce(BigDecimal::add);

        return ResponseEntity.ok(dividasCartao);

    }
}
