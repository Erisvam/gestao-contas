package br.com.gestao.contas.usuario.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gestao.contas.usuario.dto.UsuarioDTO;
import br.com.gestao.contas.usuario.entity.Usuario;

@Component
public class UsuarioMapperImpl implements UsuarioMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UsuarioDTO from(Usuario usuario) {
		return this.modelMapper.map(usuario, UsuarioDTO.class);
	}
}
