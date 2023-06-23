package br.com.gestao.contas.divida.service.impl;

import br.com.gestao.contas.divida.dto.DividaDTO;
import br.com.gestao.contas.divida.repository.DividaRepository;
import br.com.gestao.contas.divida.service.DividaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class DividaServiceImpl implements DividaService {

    private final DividaRepository dividaRepository;

    public DividaServiceImpl(DividaRepository dividaRepository) {
        this.dividaRepository = dividaRepository;
    }

    @Override
    public List<DividaDTO> consultarDividas() {
        return this.dividaRepository.findAll();
    }

    @Override
    public URI cadastrarDivida(DividaDTO divida) {
        DividaDTO dividaSalva = this.dividaRepository.save(divida);
        return UriComponentsBuilder.fromPath("/dividas/{codigo}").buildAndExpand(dividaSalva.getCodigo()).toUri();
    }

    @Override
    public ResponseEntity<?> deletarDivida(Long codigo) {
        Optional<DividaDTO> divida = this.dividaRepository.findById(codigo);
        if(divida.isPresent()){
            this.dividaRepository.delete(divida.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> editarDivida(Long codigo, DividaDTO divida) {
        Optional<DividaDTO> dividaDTO = this.dividaRepository.findById(codigo);
        if(dividaDTO.isPresent()){
            dividaDTO.get().setValor(divida.getValor());
            dividaDTO.get().setDataCompra(divida.getDataCompra());
            dividaDTO.get().setDescricao(divida.getDescricao());
            dividaDTO.get().setStatus(divida.getStatus());

            DividaDTO dividaEditada = this.dividaRepository.save(dividaDTO.get());
            return ResponseEntity.ok(dividaEditada);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<DividaDTO> consultarDivida(Long codigo) {
        Optional<DividaDTO> divida = this.dividaRepository.findById(codigo);
        return divida.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
