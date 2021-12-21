package com.cadastros.api.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.cadastros.api.entity.Lotacao;
import com.cadastros.api.service.LotacaoService;

@Component
public class StringToLotacao implements Converter<String, Lotacao>{
	@Autowired
	private LotacaoService lotacaoService;
	
	@Override
	public Lotacao convert(String text) {
		// TODO Auto-generated method stub
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return lotacaoService.buscarPorId(id);
	}

}
