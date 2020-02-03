package br.com.caixa.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Jogo {
	private String nome;
	private String genero;
	
	public Jogo() {
		// TODO Auto-generated constructor stub
	}

	public Jogo(String nome, String genero) {
		this.nome = nome;
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
