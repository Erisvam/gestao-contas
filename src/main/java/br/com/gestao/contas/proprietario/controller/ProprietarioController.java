package br.com.gestao.contas.proprietario.controller;

import br.com.gestao.contas.proprietario.dto.ProprietarioDTO;
import br.com.gestao.contas.proprietario.service.ProprietarioService;
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
    public ResponseEntity<ProprietarioDTO> cadastrarProprietario(@RequestBody ProprietarioDTO proprietario){
        URI uri = this.proprietarioService.cadastrarProprietario(proprietario);
        return ResponseEntity.created(uri).build();
    }
}
