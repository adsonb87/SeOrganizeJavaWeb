package br.com.seorganizejavaweb.usuario;

public class Usuario {
	
	private Integer idUsuario;
	private String nome;
	private String cpf;
	private String email;
	private String login;
	private String senha;
	
	
	public Usuario() {
		
	}
	
	public Usuario(String nome,	String cpf,	String email, String login,	String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.login = login;
		this.senha = senha;
	}


	public Integer getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "Usuario:\nId: " +idUsuario+ "\nNome: " +nome+ "\nCPF: " +cpf+ "\nE-mail: " +email+ "\nLogin: " +login+
				"\nSenha: "+senha;
	}
}
