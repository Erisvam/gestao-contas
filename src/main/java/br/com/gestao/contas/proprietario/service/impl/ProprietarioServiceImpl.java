package br.com.gestao.contas.proprietario.service.impl;

import br.com.gestao.contas.proprietario.dto.ProprietarioDTO;
import br.com.gestao.contas.proprietario.repository.ProprietarioRespository;
import br.com.gestao.contas.proprietario.service.ProprietarioService;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
}
