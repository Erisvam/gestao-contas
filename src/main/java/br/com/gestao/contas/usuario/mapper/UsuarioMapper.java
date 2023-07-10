package br.com.gestao.contas.usuario.mapper;

import br.com.gestao.contas.usuario.dto.UsuarioDTO;
import br.com.gestao.contas.usuario.entity.Usuario;

public interface UsuarioMapper {

    UsuarioDTO from(Usuario usuario);
}
