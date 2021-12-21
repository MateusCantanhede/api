package com.cadastros.api.dao;

import java.time.LocalDate;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.cadastros.api.entity.Lotacao;

@Repository
public class LotacaoDaoImpl extends AbstractDao<Lotacao, Long> implements LotacaoDao{

	@Override
	public List<Lotacao> findByNome(String nome) {
		// TODO Auto-generated method stub
		return createQuery("select f from Lotacao f where f.nome like concat('%',?1,'%') ", nome);
	}

	@Override
	public List<Lotacao> findByDescricao(String descricao) {
		// TODO Auto-generated method stub
		return createQuery("select f from Lotacao f where f.descricao like concat('%',?1,'%') ", descricao);
	}

	@Override
	public List<Lotacao> findByData(LocalDate data) {
		// TODO Auto-generated method stub
		String jpql = new StringBuilder("select f from Lotacao f ")
				.append("where f.data = ?1 ")
				.toString();
		return createQuery(jpql, data);
	}
	
}