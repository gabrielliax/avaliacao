package br.com.gabriel.dto;

public class RequestArquivo {

	private String caminho;
	
	private Integer profundidade;

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public Integer getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(Integer profundidade) {
		this.profundidade = profundidade;
	}
	
}
