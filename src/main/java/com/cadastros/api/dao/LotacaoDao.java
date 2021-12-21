package com.cadastros.api.dao;

import java.time.LocalDate;
import java.util.List;

import com.cadastros.api.entity.Lotacao;

public interface LotacaoDao {
	void save(Lotacao lotacao);
	
	void update(Lotacao lotacao);
	
	void delete(Long id);
	
	Lotacao findById(Long id);
	
	List<Lotacao> findAll();

	List<Lotacao> findByNome(String nome);

	List<Lotacao> findByDescricao(String descricao);

	List<Lotacao> findByData(LocalDate data);
}
