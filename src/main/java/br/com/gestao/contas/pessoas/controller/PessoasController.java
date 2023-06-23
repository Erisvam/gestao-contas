package br.com.gestao.contas.pessoas.controller;

import br.com.gestao.contas.pessoas.dto.PessoaDTO;
import br.com.gestao.contas.pessoas.repository.PessoaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

    private final PessoaRepository pessoaRepository;

    public PessoasController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarPessoas(@RequestBody PessoaDTO pessoa){
        PessoaDTO pessoaSalva = this.pessoaRepository.save(pessoa);

        URI localeUri = UriComponentsBuilder.fromPath("/pessoas/{codigo}").buildAndExpand(pessoaSalva.getCodigo()).toUri();
        return ResponseEntity.created(localeUri).build();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<PessoaDTO> consultarPessoa(@PathVariable Long codigo){
        Optional<PessoaDTO> pessoa = this.pessoaRepository.findById(codigo);
        return pessoa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<PessoaDTO> editarPessoa(@PathVariable Long codigo, @RequestBody PessoaDTO pessoaDTO){
        Optional<PessoaDTO> pessoa = this.pessoaRepository.findById(codigo);
        if(pessoa.isPresent()){
            pessoa.get().setNome(pessoaDTO.getNome());
            pessoa.get().setTelefone(pessoaDTO.getTelefone());

            PessoaDTO pessoaEditada = this.pessoaRepository.save(pessoa.get());
            return ResponseEntity.ok(pessoaEditada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long codigo){
        Optional<PessoaDTO> pessoa = this.pessoaRepository.findById(codigo);
        if(pessoa.isPresent()){
            this.pessoaRepository.delete(pessoa.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> consultarPessoas(){
        List<PessoaDTO> pessoas = this.pessoaRepository.findAll();
        return ResponseEntity.ok(pessoas);
    }
}
