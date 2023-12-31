package br.com.gestao.contas.divida.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gestao.contas.cartao.dto.CartaoResponseDTO;
import br.com.gestao.contas.cartao.dto.ValorTotalCartaoDTO;
import br.com.gestao.contas.divida.dto.DividasDetalheUsuarioDTO;
import br.com.gestao.contas.divida.entity.Divida;
import br.com.gestao.contas.usuario.dto.UsuarioDTO;

@Repository
public interface DividaRepository extends JpaRepository<Divida, Long>{

	@Query("SELECT new br.com.gestao.contas.cartao.dto.CartaoResponseDTO(cartao.nome, SUM(divida.valor)) FROM Divida AS divida INNER JOIN Cartao AS cartao ON divida.cartao.codigo = cartao.codigo WHERE divida.cartao.codigo = :codigoCartao GROUP BY cartao.nome")
    Optional<CartaoResponseDTO> getValorTotalCartao(String codigoCartao);

    @Query("SELECT new br.com.gestao.contas.usuario.dto.UsuarioDTO(usuario.nome, SUM(divida.valor)) FROM Divida AS divida INNER JOIN Usuario AS usuario ON divida.usuario.id = usuario.id WHERE divida.cartao.codigo = :codigoCartao GROUP BY usuario.nome ORDER BY divida.valor ASC")
    List<UsuarioDTO> getDividasUsuario(String codigoCartao);

    @Query("SELECT new br.com.gestao.contas.usuario.dto.UsuarioDTO(usuario.nome, SUM(divida.valor)) FROM Divida AS divida INNER JOIN Usuario AS usuario ON divida.usuario.id = usuario.id WHERE usuario.id = :idUsuario GROUP BY usuario.nome")
    Optional<UsuarioDTO> getDividaTotalUsuario(Long idUsuario);

    @Query("SELECT new br.com.gestao.contas.divida.dto.DividasDetalheUsuarioDTO(cartao.codigo, cartao.nome, divida.valor, divida.dataCompra, divida.descricao) FROM Divida AS divida INNER JOIN Cartao AS cartao ON divida.cartao.codigo = cartao.codigo INNER JOIN Usuario AS usuario ON divida.usuario.id = usuario.id WHERE usuario.nome = :nomeUsuario AND cartao.nome = :nomeCartao GROUP BY cartao.nome, divida.valor")
    List<DividasDetalheUsuarioDTO> getDetalhesDasComprasByUsuarioECartao(String nomeUsuario, String nomeCartao);

    @Query("SELECT new br.com.gestao.contas.cartao.dto.ValorTotalCartaoDTO(cartao.nome, SUM(divida.valor)) FROM Divida AS divida INNER JOIN Cartao AS cartao ON divida.cartao.codigo = cartao.codigo INNER JOIN Usuario AS usuario ON divida.usuario.id = usuario.id WHERE usuario.nome = :nomeUsuario GROUP BY cartao.nome")
    List<ValorTotalCartaoDTO> getValorTotalByCartao(String nomeUsuario);
}
