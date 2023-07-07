package br.com.gestao.contas.usuario.controller;


import br.com.gestao.contas.usuario.dto.DadosDetalhadosUsuarioDTO;
import br.com.gestao.contas.usuario.dto.UsuarioDTO;
import br.com.gestao.contas.usuario.entity.Usuario;
import br.com.gestao.contas.usuario.respository.UsuarioRepository;
import br.com.gestao.contas.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    private final UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioSalvo = this.usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }


    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios(){
        List<UsuarioDTO> usuarios = this.usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id){
        Optional<Usuario> usuarioOptional = this.usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){
            this.usuarioRepository.delete(usuarioOptional.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<List<DadosDetalhadosUsuarioDTO>> consultarDetalheDividaUsuario(@PathVariable Long id){
        List<DadosDetalhadosUsuarioDTO> dadosDetalhadosUsuarioDTOS = this.usuarioService.consultarDetalheDividaUsuario(id);
        return ResponseEntity.ok(dadosDetalhadosUsuarioDTOS);
    }
}
