package br.com.gestao.contas.divida.controller;

import br.com.gestao.contas.divida.dto.DividaDTO;
import br.com.gestao.contas.divida.respository.DividaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
