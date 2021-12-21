package com.cadastros.api.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
@SuppressWarnings("serial")
@Entity
@Table(name = "SERVIDOR")
public class Servidor extends AbstractEntity<Long> {
	
	@NotBlank
	@Column(length = 400, nullable = false)
	private String nome;
	
	@NotBlank
	@Column(length = 30, nullable = false)
	private String matricula;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(columnDefinition = "DATE")
	private LocalDate data;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_lotacao_fk")
	@NotNull
	private Lotacao lotacao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Lotacao getLotacao() {
		return lotacao;
	}
	public void setLotacao(Lotacao lotacao) {
		this.lotacao = lotacao;
	}
	
}
