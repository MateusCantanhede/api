package com.cadastros.api.service;

import java.time.LocalDate;
import java.util.List;

import com.cadastros.api.entity.Lotacao;

public interface LotacaoService {
	void salvar(Lotacao lotacao);
	
	void editar(Lotacao lotacao);
	
	void excluir(Long id);
	
	Lotacao buscarPorId(Long id);
	
	List<Lotacao> buscarTodos();

	List<Lotacao> buscarPorNome(String nome);
	
	List<Lotacao> buscarPorDescricao(String descricao);
	
	List<Lotacao> buscarPorData(LocalDate data);
	
}
