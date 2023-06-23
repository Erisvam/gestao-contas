package br.com.gestao.contas.inquilino.service.impl;

import br.com.gestao.contas.inquilino.dto.InquilinoDTO;
import br.com.gestao.contas.inquilino.respository.InquilinosRepository;
import br.com.gestao.contas.inquilino.service.InquilinosService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class InquilinosServiceImpl implements InquilinosService {

    private final InquilinosRepository inquilinosRepository;

    public InquilinosServiceImpl(InquilinosRepository inquilinosRepository) {
        this.inquilinosRepository = inquilinosRepository;
    }

    @Override
    public List<InquilinoDTO> consultarInquilinos() {
         return this.inquilinosRepository.findAll();
    }

    @Override
    public URI cadastrarInquilino(InquilinoDTO inquilino) {
        InquilinoDTO inquilinoSalvo = this.inquilinosRepository.save(inquilino);
        return UriComponentsBuilder.fromPath("/inquilinos/{codigo}").buildAndExpand(inquilinoSalvo.getCodigo()).toUri();
    }

    @Override
    public ResponseEntity<?> deletarInquilino(Long codigo) {
        Optional<InquilinoDTO> inquilino = this.inquilinosRepository.findById(codigo);
        if(inquilino.isPresent()){
            this.inquilinosRepository.delete(inquilino.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> editarInquilino(Long codigo, InquilinoDTO inquilino) {
        Optional<InquilinoDTO> inquilinoDTO = this.inquilinosRepository.findById(codigo);
        if(inquilinoDTO.isPresent()){
            inquilinoDTO.get().setNome(inquilino.getNome());
            inquilinoDTO.get().setTelefone(inquilino.getTelefone());

            InquilinoDTO inquilinoEditado = this.inquilinosRepository.save(inquilinoDTO.get());
            return ResponseEntity.ok(inquilinoEditado);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<InquilinoDTO> consultarInquilino(Long codigo) {
        Optional<InquilinoDTO> inquilino = this.inquilinosRepository.findById(codigo);
        return inquilino.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
