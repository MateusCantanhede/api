package com.cadastros.api.dao;

import java.time.LocalDate;
import java.util.List;

import com.cadastros.api.entity.Servidor;

public interface ServidorDao {
	void save(Servidor servidor);
	
	void update(Servidor servidor);
	
	void delete(Long id);
	
	Servidor findById(Long id);
	
	List<Servidor> findAll();

	List<Servidor> findByNome(String nome);
	
	List<Servidor> findByMatricula(String matricula);
	
	List<Servidor> findByData(LocalDate data);
}
