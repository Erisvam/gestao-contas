package br.com.gestao.contas.manager.controller;

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

import br.com.gestao.contas.manager.entity.Manager;
import br.com.gestao.contas.manager.repository.ManagerRepository;

@RestController
@RequestMapping("/managers")
@CrossOrigin(originPatterns = "*")
public class ManagerController {

	@Autowired
	private ManagerRepository managerRepository;
	
	@PostMapping
	public ResponseEntity<Manager> cadastrarManager(@RequestBody Manager manager) {
		Manager managerSalvo = this.managerRepository.save(manager);
		return ResponseEntity.status(HttpStatus.CREATED).body(managerSalvo);
	}

	@GetMapping
	public ResponseEntity<List<Manager>> listarManagers() {
		List<Manager> managers = this.managerRepository.findAll();
		return ResponseEntity.ok(managers);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarManager(@PathVariable Long id) {
		Optional<Manager> managerOptional = this.managerRepository.findById(id);
		if (managerOptional.isPresent()) {
			this.managerRepository.delete(managerOptional.get());
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}