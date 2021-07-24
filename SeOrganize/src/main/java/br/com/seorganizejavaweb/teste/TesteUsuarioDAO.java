package br.com.seorganizejavaweb.teste;

import java.util.ArrayList;

import br.com.seorganizejavaweb.usuario.Usuario;
import br.com.seorganizejavaweb.fachada.Fachada;
import br.com.seorganizejavaweb.usuario.RepositorioUsuarioJDBC;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		
		testeExiste();
		
	}
	
	private static void testeListar() {
		ArrayList<Usuario> listaUsuarios;
		
		RepositorioUsuarioJDBC usuarioDAO = new RepositorioUsuarioJDBC();
		
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
		
		RepositorioUsuarioJDBC userDAO = new RepositorioUsuarioJDBC();
		
		userDAO.salvarUsuario(user);
	}
	
	private static void testeAlterar() {
		Usuario user = new Usuario();
		user.setNome("Jose Edson");
		user.setCpf("000.000.000-00");
		user.setEmail("jegsouza@hotmail.com");
		user.setLogin("jegsouza");
		user.setSenha("1234");
		
		RepositorioUsuarioJDBC userDAO = new RepositorioUsuarioJDBC();
		
		userDAO.salvarUsuario(user);
	}
	
	private static void testeExcluir() {
		Usuario user = new Usuario();
		user.setIdUsuario(5);
		
		RepositorioUsuarioJDBC userDAO = new RepositorioUsuarioJDBC();
		
		userDAO.excluirUsuario(user);
	}
	
	private static void testeBuscarUsuarioId() {
		RepositorioUsuarioJDBC userDAO = new RepositorioUsuarioJDBC();
		
		Usuario user = userDAO.buscarUsuarioID(1);
		
		System.out.println(user.toString());
	}
	
	private static void testeBuscarUsuarioNome() {
		RepositorioUsuarioJDBC userDAO = new RepositorioUsuarioJDBC();
		
		Usuario user = userDAO.buscarUsuarioNome("Jose Edson");
		
		System.out.println(user.toString());
	}
	
	private static void testeAutenticarUsuario() {
		Usuario user = new Usuario();
		user.setLogin("jegsouza");
		user.setSenha("1234");
		
		RepositorioUsuarioJDBC userDAO = new RepositorioUsuarioJDBC();	
	
		System.out.println(userDAO.autenticarUsuario(user).toString());
		
	}
	
	private static void testeExiste() {
		Usuario user = new Usuario();
		user.setLogin("jegsouza");
		user.setSenha("1234");
		
		Fachada f = Fachada.getInstance();	
	
		System.out.println(f.existeUsuario(user));
		
	}

}
