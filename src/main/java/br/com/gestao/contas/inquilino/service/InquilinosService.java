package br.com.gestao.contas.inquilino.service;

import br.com.gestao.contas.inquilino.dto.InquilinoDTO;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

public interface InquilinosService {
    List<InquilinoDTO> consultarInquilinos();

    URI cadastrarInquilino(InquilinoDTO inquilino);

    ResponseEntity<?> deletarInquilino(Long codigo);

    ResponseEntity<?> editarInquilino(Long codigo, InquilinoDTO inquilino);

    ResponseEntity<InquilinoDTO> consultarInquilino(Long codigo);

}
