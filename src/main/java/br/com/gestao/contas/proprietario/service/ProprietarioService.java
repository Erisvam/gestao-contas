package br.com.gestao.contas.proprietario.service;

import br.com.gestao.contas.proprietario.dto.ProprietarioDTO;

import java.net.URI;
import java.util.List;

public interface ProprietarioService {


    List<ProprietarioDTO> consultarProprietarios();

    URI cadastrarProprietario(ProprietarioDTO proprietario);
}
