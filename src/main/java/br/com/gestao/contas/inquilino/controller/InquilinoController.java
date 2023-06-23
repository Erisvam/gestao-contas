package br.com.gestao.contas.inquilino.controller;

import br.com.gestao.contas.inquilino.dto.InquilinoDTO;
import br.com.gestao.contas.inquilino.service.InquilinosService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/inquilinos")
public class InquilinoController {

    private final InquilinosService inquilinosService;

    public InquilinoController(InquilinosService inquilinosService) {
        this.inquilinosService = inquilinosService;
    }

    @GetMapping
    public ResponseEntity<?> consultarInquilinos(){
        return ResponseEntity.ok(this.inquilinosService.consultarInquilinos());
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarInquilino(@Valid @RequestBody InquilinoDTO inquilino){
        URI uri = this.inquilinosService.cadastrarInquilino(inquilino);
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> deletarInquilino(@PathVariable Long codigo){
        return this.inquilinosService.deletarInquilino(codigo);
    }

    @PatchMapping("/{codigo}")
    public ResponseEntity<?> editarInquilino(@PathVariable Long codigo, @RequestBody InquilinoDTO inquilino){
        return this.inquilinosService.editarInquilino(codigo, inquilino);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<InquilinoDTO> consultarInquilino(@PathVariable Long codigo){
        return this.inquilinosService.consultarInquilino(codigo);
    }
}
