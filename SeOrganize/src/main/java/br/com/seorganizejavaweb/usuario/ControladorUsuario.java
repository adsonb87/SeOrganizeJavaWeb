package br.com.seorganizejavaweb.usuario;

import java.util.ArrayList;

public class ControladorUsuario {
	
	private IRepositorioUsuario repositorioUsuario;
	
	public ControladorUsuario() {
		repositorioUsuario = new RepositorioUsuarioJDBC();
	}
	
	public void cadastrarUsuario (Usuario user) {
		repositorioUsuario.cadastrarUsuario(user);
	}
	
	public void alterarUsuario (Usuario user) {
		repositorioUsuario.alterarUsuario(user);
	}
	
	public void salvarUsuario (Usuario user) {
		repositorioUsuario.salvarUsuario(user);
	}
	
	public void excluirUsuario (Usuario user) {
		repositorioUsuario.excluirUsuario(user);
	}
	
	public Usuario autenticarUsuario (Usuario user) {
		return repositorioUsuario.autenticarUsuario(user);
	}
	
	public boolean existeUsuario (Usuario user) {
		return repositorioUsuario.existeUsuario(user);
	}
	
	public Usuario buscarUsuarioID (Integer id) {
		return repositorioUsuario.buscarUsuarioID(id);
	}
	
}
