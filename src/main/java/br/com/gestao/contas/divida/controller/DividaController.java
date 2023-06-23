package br.com.gestao.contas.divida.controller;

import br.com.gestao.contas.divida.dto.DividaDTO;
import br.com.gestao.contas.divida.service.DividaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/dividas")
public class DividaController {

    private final DividaService dividaService;

    public DividaController(DividaService dividaService) {
        this.dividaService = dividaService;
    }

    @GetMapping
    public ResponseEntity<List<DividaDTO>> consultarDividas(){
        return ResponseEntity.ok(this.dividaService.consultarDividas());
    }

    @PostMapping
    public ResponseEntity<?> cadastrarDivida(@RequestBody DividaDTO divida){
        URI uri = this.dividaService.cadastrarDivida(divida);
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> deletarDivida(@PathVariable Long codigo){
        return this.dividaService.deletarDivida(codigo);
    }

    @PatchMapping("/{codigo}")
    public ResponseEntity<?> editarDivida(@PathVariable Long codigo, @RequestBody DividaDTO divida){
        return this.dividaService.editarDivida(codigo, divida);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<DividaDTO> consultarDivida(@PathVariable Long codigo){
        return this.dividaService.consultarDivida(codigo);
    }
}
