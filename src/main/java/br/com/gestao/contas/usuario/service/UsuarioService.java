package br.com.gestao.contas.usuario.service;

import br.com.gestao.contas.usuario.dto.ConsultaDividaUsuarioResponseDTO;
import br.com.gestao.contas.usuario.dto.ListaUsuariosDTO;

public interface UsuarioService {

	ConsultaDividaUsuarioResponseDTO consultarDividaUsuario(Long id);

	ListaUsuariosDTO listarUsuarios();

}
