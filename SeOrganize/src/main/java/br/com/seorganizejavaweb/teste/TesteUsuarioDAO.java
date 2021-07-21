package br.com.seorganizejavaweb.teste;

import java.util.ArrayList;

import br.com.seorganizejavaweb.entidades.Usuario;
import br.com.seorganizejavaweb.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		
		testeExiste();
		
	}
	
	private static void testeListar() {
		ArrayList<Usuario> listaUsuarios;
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		listaUsuarios = usuarioDAO.listarUsuario();
		
		for(Usuario u: listaUsuarios) {
			System.out.println(u.toString());
		}
		
	}
	
	private static void testeCadastrar() {
		Usuario user = new Usuario();
		user.setNome("Jose Edson");
		user.setCpf("000.000.000-00");
		user.setEmail("jegsouza@hotmail.com");
		user.setLogin("jegsouza");
		user.setSenha("1234");
		
		UsuarioDAO userDAO = new UsuarioDAO();
		
		userDAO.salvarUsuario(user);
	}
	
	private static void testeAlterar() {
		Usuario user = new Usuario();
		user.setNome("Jose Edson");
		user.setCpf("000.000.000-00");
		user.setEmail("jegsouza@hotmail.com");
		user.setLogin("jegsouza");
		user.setSenha("1234");
		
		UsuarioDAO userDAO = new UsuarioDAO();
		
		userDAO.salvarUsuario(user);
	}
	
	private static void testeExcluir() {
		Usuario user = new Usuario();
		user.setIdUsuario(5);
		
		UsuarioDAO userDAO = new UsuarioDAO();
		
		userDAO.excluirUsuario(user);
	}
	
	private static void testeBuscarUsuarioId() {
		UsuarioDAO userDAO = new UsuarioDAO();
		
		Usuario user = userDAO.buscarUsuarioID(1);
		
		System.out.println(user.toString());
	}
	
	private static void testeBuscarUsuarioNome() {
		UsuarioDAO userDAO = new UsuarioDAO();
		
		Usuario user = userDAO.buscarUsuarioNome("Jose Edson");
		
		System.out.println(user.toString());
	}
	
	private static void testeAutenticarUsuario() {
		Usuario user = new Usuario();
		user.setLogin("jegsouza");
		user.setSenha("1234");
		
		UsuarioDAO userDAO = new UsuarioDAO();	
	
		System.out.println(userDAO.autenticarUsuario(user).toString());
		
	}
	
	private static void testeExiste() {
		Usuario user = new Usuario();
		user.setLogin("jegsouza");
		user.setSenha("1234");
		
		UsuarioDAO userDAO = new UsuarioDAO();	
	
		System.out.println(userDAO.existeUsuario(user));
		
	}

}
