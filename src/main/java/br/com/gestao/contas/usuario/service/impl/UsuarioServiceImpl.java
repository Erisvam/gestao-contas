package br.com.gestao.contas.usuario.service.impl;

import br.com.gestao.contas.usuario.dto.DadosDetalhadosUsuarioDTO;
import br.com.gestao.contas.divida.dto.DividasDetalheUsuarioDTO;
import br.com.gestao.contas.divida.repository.DividaRepository;
import br.com.gestao.contas.usuario.dto.UsuarioDTO;
import br.com.gestao.contas.usuario.entity.Usuario;
import br.com.gestao.contas.usuario.mapper.UsuarioMapper;
import br.com.gestao.contas.usuario.respository.UsuarioRepository;
import br.com.gestao.contas.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final DividaRepository dividaRepository;

    private final UsuarioMapper usuarioMapper;

    @Override
    public List<DadosDetalhadosUsuarioDTO> consultarDetalheDividaUsuario(Long id) {
        Optional<Usuario> usuarioOptional = this.usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){
            List<DadosDetalhadosUsuarioDTO> nomeUsuarioNomeAndValorTotalCartao = this.dividaRepository.buscarNomeUsuario_NomeAndValorTotalCartao(usuarioOptional.get().getNome());
            nomeUsuarioNomeAndValorTotalCartao
                    .forEach(dadosDetalhadosUsuarioDTO -> {
                        List<DividasDetalheUsuarioDTO> dividasByUsuario = this.dividaRepository.buscar_codigoNomeCartao_valorDataCompraDescricaoDivida(dadosDetalhadosUsuarioDTO.getNomeUsuario(), dadosDetalhadosUsuarioDTO.getNomeCartao());
                        dadosDetalhadosUsuarioDTO.setDividas(dividasByUsuario);
                    });
            return nomeUsuarioNomeAndValorTotalCartao;
        }
        throw new RuntimeException();
    }

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        List<UsuarioDTO> usuarios = new ArrayList<>();
        this.usuarioRepository.findAll().stream().map(this.usuarioMapper::from).forEach(from -> {
            Optional<UsuarioDTO> usuarioDTO = this.dividaRepository.buscarValorTotalByUsuarios(from.getId());
            from.setValorTotal(usuarioDTO.isPresent() ? usuarioDTO.get().getValorTotal() : BigDecimal.ZERO);
            usuarios.add(from);
        });
        return usuarios;
    }
}
