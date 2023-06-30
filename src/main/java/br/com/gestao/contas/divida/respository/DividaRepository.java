package br.com.gestao.contas.divida.respository;

import br.com.gestao.contas.divida.dto.DividaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DividaRepository extends JpaRepository<DividaDTO, Long> {
}
