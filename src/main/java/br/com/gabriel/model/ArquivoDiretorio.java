package br.com.gabriel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TAB_HIERARQUIA")
public class ArquivoDiretorio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private Integer profundidade;
	
	@Column
	private String tipo;
	
	public ArquivoDiretorio() {

	}

	public ArquivoDiretorio(String nome, Integer profundidade, String tipo) {
		this.nome = nome;
		this.profundidade = profundidade;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(Integer profundidade) {
		this.profundidade = profundidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}