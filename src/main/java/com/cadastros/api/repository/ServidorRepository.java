package com.cadastros.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cadastros.api.entity.Servidor;


@Repository
public interface ServidorRepository extends JpaRepository<Servidor,Long>{}