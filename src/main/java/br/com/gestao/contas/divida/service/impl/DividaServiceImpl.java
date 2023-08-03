package br.com.gestao.contas.divida.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.gestao.contas.cartao.dto.CartaoResponseDTO;
import br.com.gestao.contas.divida.entity.Divida;
import br.com.gestao.contas.divida.repository.DividaRepository;
import br.com.gestao.contas.divida.service.DividaService;
import br.com.gestao.contas.usuario.dto.UsuarioDTO;

@Service
public class DividaServiceImpl implements DividaService {

	@Autowired
    private DividaRepository dividaRepository;
    
	@Override
    public List<UsuarioDTO> getDividasUsuario(String codigoCartao) {
        return this.dividaRepository.getDividasUsuario(codigoCartao);
    }

    @Override
    public Optional<CartaoResponseDTO> getValorTotalCartao(String codigoCartao) {
        return this.dividaRepository.getValorTotalCartao(codigoCartao);
    }

	@Override
	public void cadastrarDivida(Divida divida) {
		this.dividaRepository.save(divida);
	}

	@Override
	public List<Divida> listarDividas() {
		return this.dividaRepository.findAll();
	}

	@Override
	public void deletarDivida(Long id) {
		Optional<Divida> dividaOptional = this.dividaRepository.findById(id);
		if(dividaOptional.isPresent()) {
			this.dividaRepository.delete(dividaOptional.get());
			return;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "divida não encontrada");
	}
}
