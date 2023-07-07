package br.com.gestao.contas.manager.controller;

import br.com.gestao.contas.manager.entity.Manager;
import br.com.gestao.contas.manager.repository.ManagerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")
public class ManagerController {

    private final ManagerRepository managerRepository;

    @PostMapping
    public ResponseEntity<Manager> cadastrarManager(@RequestBody Manager manager){
        Manager managerSalvo = this.managerRepository.save(manager);
        return ResponseEntity.status(HttpStatus.CREATED).body(managerSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Manager>> listarManagers(){
        List<Manager> managers = this.managerRepository.findAll();
        return ResponseEntity.ok(managers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarManager(@PathVariable Long id){
        Optional<Manager> managerOptional = this.managerRepository.findById(id);
        if(managerOptional.isPresent()){
            this.managerRepository.delete(managerOptional.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
