package com.cadastros.api.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "LOTACAO")
public class Lotacao extends AbstractEntity<Long>{
	
	@NotBlank
	@Column(nullable = false)
	private String nome;
	
	@NotBlank
	@Column(length = 200,nullable = false)
	private String descricao;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(columnDefinition = "DATE")
	private LocalDate data;
	
	@OneToMany(mappedBy = "lotacao")
	private List<Servidor> servidores;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public List<Servidor> getServidores() {
		return servidores;
	}
	public void setServidores(List<Servidor> servidores) {
		this.servidores = servidores;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
