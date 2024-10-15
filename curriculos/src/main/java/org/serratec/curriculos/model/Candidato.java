package org.serratec.curriculos.model;

import java.time.LocalDate;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="candidato")
public class Candidato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min=3, message="O nome deve conter ao menos 3 letras.")
	private String nome;
	@NonNull
	@Past
	private LocalDate dataNascimento;
	@NotBlank
	private String cpf;
	@Enumerated(EnumType.STRING)
	private Escolaridade escolaridade;
	@Enumerated(EnumType.STRING)
	private Vaga vagaDesejada;
	@Enumerated(EnumType.STRING)
	private StatusC statusCurriculo;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Escolaridade getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}
	public Vaga getVagaDesejada() {
		return vagaDesejada;
	}
	public void setVagaDesejada(Vaga vagaDesejada) {
		this.vagaDesejada = vagaDesejada;
	}
	public StatusC getStatusCurriculo() {
		return statusCurriculo;
	}
	public void setStatusCurriculo(StatusC statusCurriculo) {
		this.statusCurriculo = statusCurriculo;
	}
	
}
