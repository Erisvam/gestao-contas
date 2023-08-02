package br.com.gestao.contas.divida.service;

import br.com.gestao.contas.divida.dto.DividaDTO;
import br.com.gestao.contas.divida.entity.Divida;

public interface DividaMapperService {

	Divida to(DividaDTO dividaDTO);

}
