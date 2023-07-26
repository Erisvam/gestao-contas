package br.com.gestao.contas.divida.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestao.contas.cartao.dto.CartaoResponseDTO;
import br.com.gestao.contas.divida.repository.DividaRepository;
import br.com.gestao.contas.divida.service.DividaService;
import br.com.gestao.contas.usuario.dto.UsuarioDTO;

@Service
public class DividaServiceImpl implements DividaService {

	@Autowired
    private DividaRepository dividaRepository;
    
	@Override
    public List<UsuarioDTO> buscarDividasUsuarioPorCartao(String codigoCartao) {
        return this.dividaRepository.buscarValorTotalByUsuario(codigoCartao);
    }

    @Override
    public Optional<CartaoResponseDTO> buscarValorTotalPorCartao(String codigoCartao) {
        return this.dividaRepository.buscarValorTotalByCartao(codigoCartao);
    }
}
