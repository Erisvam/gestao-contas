package br.com.gestao.contas.usuario.mapper;

import br.com.gestao.contas.usuario.dto.UsuarioDTO;
import br.com.gestao.contas.usuario.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    private final ModelMapper modelMapper;

    @Override
    public UsuarioDTO from(Usuario usuario) {
        return this.modelMapper.map(usuario, UsuarioDTO.class);
    }
}
