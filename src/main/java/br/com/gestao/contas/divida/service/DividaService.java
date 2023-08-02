package br.com.gestao.contas.divida.service;

import java.util.List;
import java.util.Optional;

import br.com.gestao.contas.cartao.dto.CartaoResponseDTO;
import br.com.gestao.contas.divida.entity.Divida;
import br.com.gestao.contas.usuario.dto.UsuarioDTO;

public interface DividaService {

	List<UsuarioDTO> getDividasUsuario(String codigoCartao);

	Optional<CartaoResponseDTO> getValorTotalCartao(String codigoCartao);

	void cadastrarDivida(Divida dividaRequestEntity);

	List<Divida> listarDividas();

	void deletarDivida(Long id);

}
