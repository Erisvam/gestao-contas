package br.com.gestao.contas.dividas.controller;

import br.com.gestao.contas.dividas.dto.DividaDTO;
import br.com.gestao.contas.dividas.mapper.DividaMapper;
import br.com.gestao.contas.dividas.repository.DividaRepository;
import br.com.gestao.contas.dividas.viewmodel.DividaViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/dividas")
public class DividasController {

    private final DividaRepository dividaRepository;

    public DividasController(DividaRepository dividaRepository) {
        this.dividaRepository = dividaRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarDividas(@RequestBody DividaDTO dividaDTO){
        DividaDTO dividaSalva = this.dividaRepository.save(dividaDTO);

        URI localeUri = UriComponentsBuilder.fromPath("/dividas/{codigo}").buildAndExpand(dividaSalva.getCodigo()).toUri();
        return ResponseEntity.created(localeUri).build();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<DividaViewModel> consultarDivida(@PathVariable Long codigo){
        Optional<DividaDTO> divida = this.dividaRepository.findById(codigo);
        if(divida.isPresent()){
            DividaViewModel from = DividaMapper.from(divida);
            return ResponseEntity.ok(from);
        }
        return ResponseEntity.notFound().build();
    }
}
