package br.com.gestao.contas.divida.service;

import br.com.gestao.contas.divida.dto.DividaDTO;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

public interface DividaService {
    List<DividaDTO> consultarDividas();

    URI cadastrarDivida(DividaDTO divida);

    ResponseEntity<?> deletarDivida(Long codigo);

    ResponseEntity<?> editarDivida(Long codigo, DividaDTO divida);

    ResponseEntity<DividaDTO> consultarDivida(Long codigo);

}
