package com.cadastros.api.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cadastros.api.dao.LotacaoDao;
import com.cadastros.api.entity.Lotacao;

@Service
@Transactional(readOnly = true)
public class LotacaoServiceImpl implements LotacaoService{
	@Autowired
	private LotacaoDao dao;
	
	@Override
	@Transactional(readOnly = false)
	public void salvar(Lotacao lotacao) {
		// TODO Auto-generated method stub
		dao.save(lotacao);
	}

	@Override
	@Transactional(readOnly = false)
	public void editar(Lotacao lotacao) {
		// TODO Auto-generated method stub
		dao.update(lotacao);
	}

	@Override
	@Transactional(readOnly = false)
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Lotacao buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Lotacao> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<Lotacao> buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return dao.findByNome(nome);
	}

	@Override
	public List<Lotacao> buscarPorDescricao(String descricao) {
		// TODO Auto-generated method stub
		return dao.findByDescricao(descricao);
	}

	@Override
	public List<Lotacao> buscarPorData(LocalDate data) {
		// TODO Auto-generated method stub
		if (data!= null) {
			return dao.findByData(data);
		}else {
			return new ArrayList<>();
		}
		
	}

}
