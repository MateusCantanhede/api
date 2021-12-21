package com.cadastros.api.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cadastros.api.entity.Servidor;

@Repository
public class ServidorDaoImpl extends AbstractDao<Servidor, Long> implements ServidorDao{

	@Override
	public List<Servidor> findByNome(String nome) {
		// TODO Auto-generated method stub
		return createQuery("select f from Servidor f where f.nome like concat('%',?1,'%') ", nome);
	}

	@Override
	public List<Servidor> findByMatricula(String matricula) {
		// TODO Auto-generated method stub
		return createQuery("select f from Servidor f where f.matricula like concat('%',?1,'%') ", matricula);
	}

	@Override
	public List<Servidor> findByData(LocalDate data) {
		// TODO Auto-generated method stub
		String jpql = new StringBuilder("select f from Servidor f ")
				.append("where f.data = ?1 ")
				.toString();
		return createQuery(jpql, data);
	}
	
}
