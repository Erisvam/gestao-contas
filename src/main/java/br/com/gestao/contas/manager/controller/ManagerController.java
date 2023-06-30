package br.com.gestao.contas.manager.controller;

import br.com.gestao.contas.manager.dto.ManagerDTO;
import br.com.gestao.contas.manager.respository.ManagerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    private final ManagerRepository managerRepository;

    public ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @PostMapping
    public ResponseEntity<ManagerDTO> cadastrarManager(@RequestBody ManagerDTO managerDTO){
        return ResponseEntity.ok(this.managerRepository.save(managerDTO));
    }

    @GetMapping
    public ResponseEntity<List<ManagerDTO>> listarManagers(){
        return ResponseEntity.ok(this.managerRepository.findAll());
    }
}
