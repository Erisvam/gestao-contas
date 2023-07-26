package br.com.gestao.contas.usuario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestao.contas.usuario.dto.DadosDetalhadosUsuarioDTO;
import br.com.gestao.contas.usuario.dto.UsuarioDTO;
import br.com.gestao.contas.usuario.entity.Usuario;
import br.com.gestao.contas.usuario.repository.UsuarioRepository;
import br.com.gestao.contas.usuario.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(originPatterns = "*")
public class UsuarioController {

	@Autowired
    private UsuarioService usuarioService;

	@Autowired
    private UsuarioRepository usuarioRepository;
    
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
