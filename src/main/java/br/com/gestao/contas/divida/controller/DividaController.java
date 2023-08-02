package br.com.gestao.contas.divida.controller;

import java.util.List;

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

import br.com.gestao.contas.divida.dto.DividaDTO;
import br.com.gestao.contas.divida.entity.Divida;
import br.com.gestao.contas.divida.service.DividaMapperService;
import br.com.gestao.contas.divida.service.DividaService;

@RestController
@RequestMapping("/dividas")
@CrossOrigin(originPatterns = "*")
public class DividaController {
	
	@Autowired
	private DividaService dividaService;
	
	@Autowired
	private DividaMapperService dividaMapper;

	@PostMapping
	public ResponseEntity<?> cadastrarDivida(@RequestBody DividaDTO dividaDTO){
		Divida dividaRequestEntity = dividaMapper.to(dividaDTO);
		dividaService.cadastrarDivida(dividaRequestEntity);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping
	public ResponseEntity<List<Divida>> listarDividas() {
		return ResponseEntity.ok(dividaService.listarDividas());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarDivida(@PathVariable Long id) {
		dividaService.deletarDivida(id);
		return ResponseEntity.noContent().build();
	}
}
