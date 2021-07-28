package br.com.seorganizejavaweb.controller;

import java.io.IOException;

import br.com.seorganizejavaweb.fachada.Fachada;
import br.com.seorganizejavaweb.usuario.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class AutenticadorController
 */
public class AutenticadorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticadorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession(false);
		
		if(sessao != null) {
			sessao.invalidate();
		}
		
		response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando doPost Autenticacao");
		
		String login = request.getParameter("txtlogin");
		String senha = request.getParameter("txtsenha");
		
		Usuario user = new Usuario();
		user.setLogin(login);
		user.setSenha(senha);
		
		Fachada fachada = Fachada.getInstance();
		Usuario usuarioAutenticado = fachada.autenticarUsuario(user);
		
		if(user != null) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioAutenticado", usuarioAutenticado);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			response.sendRedirect("login.html");
		}
		
	}

}
