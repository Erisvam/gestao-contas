package br.com.gestao.contas.usuario.service;

import java.util.List;

import br.com.gestao.contas.usuario.dto.DadosDetalhadosUsuarioResponseDTO;
import br.com.gestao.contas.usuario.dto.UsuarioDTO;

public interface UsuarioService {

	DadosDetalhadosUsuarioResponseDTO consultarDetalheDividaUsuario(Long id);

	List<UsuarioDTO> listarUsuarios();

}
