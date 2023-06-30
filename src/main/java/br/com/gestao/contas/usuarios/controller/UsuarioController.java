package br.com.gestao.contas.usuarios.controller;

import br.com.gestao.contas.usuarios.dto.UsuarioDTO;
import br.com.gestao.contas.usuarios.respository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(originPatterns = "*")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return ResponseEntity.ok(this.usuarioRepository.save(usuarioDTO));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios(){
        return ResponseEntity.ok(this.usuarioRepository.findAll());
    }
}
