package com.cadastros.api.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cadastros.api.dao.ServidorDao;
import com.cadastros.api.entity.Servidor;

@Service
@Transactional(readOnly = true)
public class ServidorServiceImpl implements ServidorService{
	@Autowired
	private ServidorDao dao;
	
	@Override
	@Transactional(readOnly = false)
	public void salvar(Servidor servidor) {
		// TODO Auto-generated method stub
		dao.save(servidor);
	}

	@Override
	@Transactional(readOnly = false)
	public void editar(Servidor servidor) {
		// TODO Auto-generated method stub
		dao.update(servidor);
	}

	@Override
	@Transactional(readOnly = false)
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Servidor buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Servidor> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public boolean ServiceTemLotacao(Long id) {
		// TODO Auto-generated method stub
		if(buscarPorId(id).getLotacao() == null) {
			return false;
		}
		return true;
	}

	@Override
	public List<Servidor> buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		
		return dao.findByNome(nome);
	}
	@Override
	public List<Servidor> buscarPorMatricula(String matricula) {
		// TODO Auto-generated method stub
		
		return dao.findByMatricula(matricula);
	}
	@Override
	public List<Servidor> buscarPorData(LocalDate data) {
		// TODO Auto-generated method stub	
		return dao.findByData(data);
	}

}
