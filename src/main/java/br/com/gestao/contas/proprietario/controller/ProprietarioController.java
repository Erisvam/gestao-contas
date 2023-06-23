package br.com.gestao.contas.proprietario.controller;

import br.com.gestao.contas.proprietario.dto.ProprietarioDTO;
import br.com.gestao.contas.proprietario.service.ProprietarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    private final ProprietarioService proprietarioService;

    public ProprietarioController(ProprietarioService proprietarioService) {
        this.proprietarioService = proprietarioService;
    }

    @GetMapping
    public ResponseEntity<?> consultarProprietarios(){
        return ResponseEntity.ok(this.proprietarioService.consultarProprietarios());
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarProprietario(@Valid @RequestBody ProprietarioDTO proprietario){
        URI uri = this.proprietarioService.cadastrarProprietario(proprietario);
        return ResponseEntity.created(uri).build();
    }

    @PatchMapping("/{codigo}")
    public ResponseEntity<?> editarProprietario(@PathVariable Long codigo, @Valid @RequestBody ProprietarioDTO proprietario){
        return this.proprietarioService.editarProprietario(codigo, proprietario);
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<ProprietarioDTO> consultarProprietario(@PathVariable Long codigo){
        return this.proprietarioService.consultarProprietario(codigo);
    }
}
