package com.cadastros.api.service;

import java.time.LocalDate;
import java.util.List;

import com.cadastros.api.entity.Servidor;

public interface ServidorService {
	void salvar(Servidor servidor);
	
	void editar(Servidor servidor);
	
	void excluir(Long id);
	
	Servidor buscarPorId(Long id);
	
	List<Servidor> buscarTodos();

	boolean ServiceTemLotacao(Long id);

	List<Servidor> buscarPorNome(String nome);
	
	List<Servidor> buscarPorMatricula(String matricula);
	
	List<Servidor> buscarPorData(LocalDate data);
}
