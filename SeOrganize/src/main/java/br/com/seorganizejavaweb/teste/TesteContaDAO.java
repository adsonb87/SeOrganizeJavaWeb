package br.com.seorganizejavaweb.teste;

import br.com.seorganizejavaweb.conta.Conta;
import br.com.seorganizejavaweb.conta.RepositorioContaJDBC;
import br.com.seorganizejavaweb.fachada.Fachada;

public class TesteContaDAO {

	public static void main(String[] args) {
		
		listarContasUsuario();
	}
	
	private static void cadastraAlteraConta () {
		RepositorioContaJDBC contaDAO = new RepositorioContaJDBC();
		Conta conta = new Conta();
		
		//conta.setIdConta(1);
		//conta.setIdUsuario(7);
		conta.setDescricao("Cartão de Crédito Nubank");
		conta.setSaldoCredito(1000);
		conta.setSaldoDebito(200);
		conta.setSaldoDinheiro(0);
		conta.setTotalPagar(1200);
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
