package com.cadastros.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cadastros.api.entity.Lotacao;

@Repository
public interface LotacaoRepository extends JpaRepository<Lotacao,Long>{}
