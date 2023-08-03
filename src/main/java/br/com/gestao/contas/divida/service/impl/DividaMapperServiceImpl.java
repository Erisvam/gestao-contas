package br.com.gestao.contas.divida.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestao.contas.divida.dto.DividaDTO;
import br.com.gestao.contas.divida.entity.Divida;
import br.com.gestao.contas.divida.service.DividaMapperService;

@Service
public class DividaMapperServiceImpl implements DividaMapperService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Divida to(DividaDTO dividaDTO) {
		return this.modelMapper.map(dividaDTO, Divida.class);
	}

}
