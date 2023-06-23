package br.com.gestao.contas.proprietario.service;

import br.com.gestao.contas.proprietario.dto.ProprietarioDTO;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

public interface ProprietarioService {


    List<ProprietarioDTO> consultarProprietarios();

    URI cadastrarProprietario(ProprietarioDTO proprietario);

    ResponseEntity<?> editarProprietario(Long codigo, ProprietarioDTO proprietario);

    ResponseEntity<ProprietarioDTO> consultarProprietario(Long codigo);
}
