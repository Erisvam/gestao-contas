package br.com.gestao.contas.divida.repository;

import br.com.gestao.contas.divida.dto.DividaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface DividaRepository extends JpaRepository<DividaDTO, Long> {
}
