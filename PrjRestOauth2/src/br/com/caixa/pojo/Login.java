package br.com.caixa.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Login {

	private String usuario;
	private String senha;
	
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
