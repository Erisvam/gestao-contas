package br.com.gestao.contas.proprietario.service.impl;

import br.com.gestao.contas.proprietario.dto.ProprietarioDTO;
import br.com.gestao.contas.proprietario.repository.ProprietarioRespository;
import br.com.gestao.contas.proprietario.service.ProprietarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class ProprietarioServiceImpl implements ProprietarioService {

    private final ProprietarioRespository proprietarioRespository;

    public ProprietarioServiceImpl(ProprietarioRespository proprietarioRespository) {
        this.proprietarioRespository = proprietarioRespository;
    }

    @Override
    public List<ProprietarioDTO> consultarProprietarios() {
        return this.proprietarioRespository.findAll();
    }

    @Override
    public URI cadastrarProprietario(ProprietarioDTO proprietario) {
        ProprietarioDTO proprietarioSalvo = this.proprietarioRespository.save(proprietario);
        return UriComponentsBuilder.fromPath("/proprietario/{codigo}").buildAndExpand(proprietarioSalvo.getCodigo()).toUri();
    }

    @Override
    public ResponseEntity<?> editarProprietario(Long codigo, ProprietarioDTO proprietario) {
        Optional<ProprietarioDTO> proprietarioDTO = this.proprietarioRespository.findById(codigo);
        if(proprietarioDTO.isPresent()){
            proprietarioDTO.get().setNome(proprietario.getNome());
            ProprietarioDTO proprietarioEditado = this.proprietarioRespository.save(proprietarioDTO.get());
            return ResponseEntity.ok(proprietarioEditado);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<ProprietarioDTO> consultarProprietario(Long codigo) {
        Optional<ProprietarioDTO> proprietario = this.proprietarioRespository.findById(codigo);
        return proprietario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
