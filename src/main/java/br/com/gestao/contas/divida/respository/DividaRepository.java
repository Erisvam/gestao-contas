package br.com.gestao.contas.divida.respository;

import br.com.gestao.contas.divida.dto.DividaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DividaRepository extends JpaRepository<DividaDTO, Long> {

    @Query("select dividas from DividaDTO dividas where dividas.cartao.codigo = :codigoCartao")
    List<DividaDTO> findByCodigoCartao(String codigoCartao);
}
