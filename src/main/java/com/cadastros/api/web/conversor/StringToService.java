package com.cadastros.api.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.cadastros.api.entity.Servidor;
import com.cadastros.api.service.ServidorService;

@Component
public class StringToService implements Converter<String, Servidor> {

	@Autowired
	private ServidorService servidorService;
	@Override
	public Servidor convert(String text) {
		// TODO Auto-generated method stub
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return servidorService.buscarPorId(id);
	}

}
