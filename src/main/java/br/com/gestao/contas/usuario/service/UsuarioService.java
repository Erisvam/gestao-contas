package br.com.gestao.contas.usuario.service;

import br.com.gestao.contas.usuario.dto.DadosDetalhadosUsuarioDTO;
import br.com.gestao.contas.usuario.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    List<DadosDetalhadosUsuarioDTO> consultarDetalheDividaUsuario(Long id);

    List<UsuarioDTO> listarUsuarios();

}
