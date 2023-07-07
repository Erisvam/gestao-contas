package br.com.gestao.contas.divida.controller;

import br.com.gestao.contas.divida.entity.Divida;
import br.com.gestao.contas.divida.repository.DividaRepository;
import br.com.gestao.contas.usuario.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dividas")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")
public class DividaController {

    private final DividaRepository dividaRepository;

    @PostMapping
    public ResponseEntity<Divida> cadastrarDivida(@RequestBody Divida usuario){
        Divida dividaSalva = this.dividaRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(dividaSalva);
    }


    @GetMapping
    public ResponseEntity<List<Divida>> listarDividas(){
        List<Divida> dividas = this.dividaRepository.findAll();
        return ResponseEntity.ok(dividas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarDivida(@PathVariable Long id){
        Optional<Divida> dividaOptional = this.dividaRepository.findById(id);
        if(dividaOptional.isPresent()){
            this.dividaRepository.delete(dividaOptional.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
