package br.com.gestao.contas.usuario.service;

import java.util.List;

import br.com.gestao.contas.usuario.dto.DadosDetalhadosUsuarioDTO;
import br.com.gestao.contas.usuario.dto.UsuarioDTO;

public interface UsuarioService {

	List<DadosDetalhadosUsuarioDTO> consultarDetalheDividaUsuario(Long id);

	List<UsuarioDTO> listarUsuarios();

}
