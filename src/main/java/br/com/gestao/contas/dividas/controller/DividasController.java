package br.com.gestao.contas.dividas.controller;

import br.com.gestao.contas.dividas.dto.DividaDTO;
import br.com.gestao.contas.dividas.mapper.DividaMapper;
import br.com.gestao.contas.dividas.repository.DividaRepository;
import br.com.gestao.contas.dividas.viewmodel.AlteraDividasViewModel;
import br.com.gestao.contas.dividas.viewmodel.DividaViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
            DividaViewModel from = DividaMapper.from(divida.get());
            return ResponseEntity.ok(from);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DividaViewModel> alterarDivida(@PathVariable Long codigo, @RequestBody AlteraDividasViewModel dividaAlterada){
        Optional<DividaDTO> divida = this.dividaRepository.findById(codigo);
        if(divida.isPresent()){
            divida.get().setValor(dividaAlterada.getValor());
            divida.get().setDataCompra(dividaAlterada.getDataCompra());
            divida.get().setDescricao(dividaAlterada.getDescricao());
            divida.get().setStatus(dividaAlterada.getStatus());
            divida.get().getCartao().setNome(dividaAlterada.getCartao().getNome());
            divida.get().getCartao().setFuncionalidade(dividaAlterada.getCartao().getFuncionalidade());

            DividaDTO dividaAlteradaDTO = this.dividaRepository.save(divida.get());
            return ResponseEntity.ok(DividaMapper.from(dividaAlteradaDTO));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> deletarDivida(@PathVariable Long codigo){
        Optional<DividaDTO> divida = this.dividaRepository.findById(codigo);
        if(divida.isPresent()){
            this.dividaRepository.delete(divida.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<DividaViewModel>> consultarDividas(){
        List<DividaDTO> dividaDTOs = this.dividaRepository.findAll();
        return ResponseEntity.ok(
                dividaDTOs
                .stream()
                .map(DividaMapper::from)
                .collect(Collectors.toList()));
    }
}
