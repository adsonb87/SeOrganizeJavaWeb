package br.com.seorganizejavaweb.usuario;

import java.util.ArrayList;

public interface IRepositorioUsuario {
	
	public void cadastrarUsuario (Usuario user);
	public void alterarUsuario (Usuario user);
	public void salvarUsuario (Usuario user);
	public void excluirUsuario (Usuario user);
	public Usuario autenticarUsuario (Usuario user);
	public boolean existeUsuario (Usuario user);
	
	
}
