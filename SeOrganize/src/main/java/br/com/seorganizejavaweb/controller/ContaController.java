package br.com.seorganizejavaweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import br.com.seorganizejavaweb.conta.Conta;
import br.com.seorganizejavaweb.fachada.Fachada;
import br.com.seorganizejavaweb.usuario.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class ContaController
 */
public class ContaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando doPost Conta");
		
		HttpSession session = request.getSession();
		
		String id = request.getParameter("txtid");
		String desc = request.getParameter("txtdesc");
		String sldCred = request.getParameter("txtsldcred");
		String sldDebt = request.getParameter("txtslddeb");
		String sldMoed = request.getParameter("txtslddin");
		String totPag = request.getParameter("txttotpag");
		String totRec = request.getParameter("txttotrec");
		
		Usuario user = new Usuario();
		user.setIdUsuario(1);
		
		Conta conta = new Conta();
		
		if(id!=null && id!= "0" && id!="") {
			conta.setIdConta(Integer.parseInt(id));
		}
		conta.setDescricao(desc);
		conta.setSaldoCredito(Double.parseDouble(sldCred));
		conta.setSaldoDebito(Double.parseDouble(sldDebt));
		conta.setSaldoDinheiro(Double.parseDouble(sldMoed));
		conta.setTotalPagar(Double.parseDouble(totPag));
		conta.setTotalReceber(Double.parseDouble(totRec));
		conta.setUsuario(user);
		
		Fachada fachada = Fachada.getInstance();
		
		PrintWriter saida = response.getWriter();
		saida.println("Cadastrado");
		
		fachada.cadastrarConta(conta);
		
		response.sendRedirect("index.jsp");
		
	}

}
