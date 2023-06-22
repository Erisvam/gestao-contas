package br.com.gestao.contas.dividas.repository;

import br.com.gestao.contas.dividas.dto.DividaDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DividaRepository extends JpaRepository<DividaDTO, Long> {
}
