package br.com.seorganizejavaweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import br.com.seorganizejavaweb.fachada.Fachada;
import br.com.seorganizejavaweb.usuario.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UsuarioController
 */
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando doGet Usuario");
		
		String acao = request.getParameter("acao");
		
		Fachada fachada = Fachada.getInstance();
		
		if(acao != null && acao.equals("altUsuario")) {
			
			String id = request.getParameter("id");
			Usuario user = new Usuario();
			user.setIdUsuario(Integer.parseInt(id));
			
			request.setAttribute("usuario", user);
			
			RequestDispatcher saida = request.getRequestDispatcher("frmusuario.jsp");
			saida.forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando doPost Usuario");
		
		String id = request.getParameter("txtid");
		String nome = request.getParameter("txtnome");
		String cpf = request.getParameter("txtcpf");
		String email = request.getParameter("txtemail");
		String login = request.getParameter("txtlogin");
		String senha = request.getParameter("txtsenha");
		
		Usuario user = new Usuario();
		
		if(id!=null && id!="0" && id!="") {
			user.setIdUsuario(Integer.parseInt(id));
		}
		user.setNome(nome);
		user.setCpf(cpf);
		user.setEmail(email);
		user.setLogin(login);
		user.setSenha(senha);
		
		Fachada fachada = Fachada.getInstance();
		
		fachada.salvarUsuario(user);
		
		PrintWriter saida = response.getWriter();
		saida.println("Cadastrado");
		
	}

}
