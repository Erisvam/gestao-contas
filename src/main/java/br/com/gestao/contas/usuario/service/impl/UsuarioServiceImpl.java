package br.com.gestao.contas.usuario.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestao.contas.divida.dto.DividasDetalheUsuarioDTO;
import br.com.gestao.contas.divida.repository.DividaRepository;
import br.com.gestao.contas.usuario.dto.DadosDetalhadosUsuarioDTO;
import br.com.gestao.contas.usuario.dto.DadosDetalhadosUsuarioResponseDTO;
import br.com.gestao.contas.usuario.dto.UsuarioDTO;
import br.com.gestao.contas.usuario.entity.Usuario;
import br.com.gestao.contas.usuario.mapper.UsuarioMapper;
import br.com.gestao.contas.usuario.repository.UsuarioRepository;
import br.com.gestao.contas.usuario.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private DividaRepository dividaRepository;
	
	@Autowired
	private UsuarioMapper usuarioMapper;

	@Override
	public DadosDetalhadosUsuarioResponseDTO consultarDetalheDividaUsuario(Long id) {
		Optional<Usuario> usuarioOptional = this.usuarioRepository.findById(id);
		if (usuarioOptional.isPresent()) {
			List<DadosDetalhadosUsuarioDTO> nomeUsuarioNomeAndValorTotalCartao = this.dividaRepository
					.buscarNomeUsuario_NomeAndValorTotalCartao(usuarioOptional.get().getNome());
			nomeUsuarioNomeAndValorTotalCartao.forEach(dadosDetalhadosUsuarioDTO -> {
				List<DividasDetalheUsuarioDTO> dividasByUsuario = this.dividaRepository
						.buscar_codigoNomeCartao_valorDataCompraDescricaoDivida(
								dadosDetalhadosUsuarioDTO.getNomeUsuario(), dadosDetalhadosUsuarioDTO.getNomeCartao());
				dadosDetalhadosUsuarioDTO.setDividas(dividasByUsuario);
			});
			
			BigDecimal saldoDevedor = getSaldoDevedor(nomeUsuarioNomeAndValorTotalCartao);
			
			return new DadosDetalhadosUsuarioResponseDTO(usuarioOptional.get().getNome(), saldoDevedor, nomeUsuarioNomeAndValorTotalCartao);
		}
		throw new RuntimeException();
	}

	private BigDecimal getSaldoDevedor(List<DadosDetalhadosUsuarioDTO> nomeUsuarioNomeAndValorTotalCartao) {
		return nomeUsuarioNomeAndValorTotalCartao
			.stream()
			.map(dadosDetalhe -> dadosDetalhe.getValorTotalCartao())
			.reduce(BigDecimal.ZERO, BigDecimal::add);
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