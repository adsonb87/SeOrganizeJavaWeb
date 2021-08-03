package br.com.seorganizejavaweb.teste;

import br.com.seorganizejavaweb.conta.Conta;
import br.com.seorganizejavaweb.conta.RepositorioContaJDBC;
import br.com.seorganizejavaweb.fachada.Fachada;
import br.com.seorganizejavaweb.usuario.Usuario;

public class TesteContaDAO {

	public static void main(String[] args) {
		
		cadastraAlteraConta();
	}
	
	private static void cadastraAlteraConta () {
		RepositorioContaJDBC contaDAO = new RepositorioContaJDBC();
		Conta conta = new Conta();
		
		Usuario user = new Usuario();
		user.setIdUsuario(1);
		
		//conta.setIdConta(1);
		conta.setUsuario(user);
		conta.setDescricao("Cartão de Crédito nubank");
		conta.setSaldoCredito(2000);
		conta.setSaldoDebito(100);
		conta.setSaldoDinheiro(0);
		conta.setTotalPagar(2100);
		conta.setTotalReceber(0);
		
		contaDAO.salvarConta(conta);
	}
	
	private static void excluirConta() {
		Conta conta = new Conta();
		
		conta.setIdConta(3);
		
		RepositorioContaJDBC contaDao = new RepositorioContaJDBC();
		
		contaDao.excluirConta(conta);
	}
	
	private static void listarContas() {
		RepositorioContaJDBC contaDao = new RepositorioContaJDBC();
		
		System.out.println(contaDao.listarContas().toString());
	}
	
	private static void listarContasUsuario() {
		Fachada f = Fachada.getInstance();
		
		System.out.println(f.listarContasUsuario(6).toString());
	}
	
	private static void buscarConta() {
		RepositorioContaJDBC contaDao = new RepositorioContaJDBC();
		
		System.out.println(contaDao.buscarConta(4).toString());
	}

}
