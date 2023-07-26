package br.com.gestao.contas.divida.controller;

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

import br.com.gestao.contas.divida.entity.Divida;
import br.com.gestao.contas.divida.repository.DividaRepository;

@RestController
@RequestMapping("/dividas")
@CrossOrigin(originPatterns = "*")
public class DividaController {

	@Autowired
	private DividaRepository dividaRepository;
	
	@PostMapping
	public ResponseEntity<Divida> cadastrarDivida(@RequestBody Divida usuario) {
		Divida dividaSalva = this.dividaRepository.save(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(dividaSalva);
	}

	@GetMapping
	public ResponseEntity<List<Divida>> listarDividas() {
		List<Divida> dividas = this.dividaRepository.findAll();
		return ResponseEntity.ok(dividas);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarDivida(@PathVariable Long id) {
		Optional<Divida> dividaOptional = this.dividaRepository.findById(id);
		if (dividaOptional.isPresent()) {
			this.dividaRepository.delete(dividaOptional.get());
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
