package br.com.seorganizejavaweb.teste;

import br.com.seorganizejavaweb.entidades.Conta;
import br.com.seorganizejavaweb.jdbc.ContaDAO;

public class TesteContaDAO {

	public static void main(String[] args) {
		
		buscarConta();
	}
	
	private static void cadastraAlteraConta () {
		ContaDAO contaDAO = new ContaDAO();
		Conta conta = new Conta();
		
		//conta.setIdConta(1);
		conta.setIdUsuario(7);
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
		
		ContaDAO contaDao = new ContaDAO();
		
		contaDao.excluirConta(conta);
	}
	
	private static void listarContas() {
		ContaDAO contaDao = new ContaDAO();
		
		System.out.println(contaDao.listarContas().toString());
	}
	
	private static void listarContasUsuario() {
		ContaDAO contaDao = new ContaDAO();
		
		System.out.println(contaDao.listarContasUsuario(6).toString());
	}
	
	private static void buscarConta() {
		ContaDAO contaDao = new ContaDAO();
		
		System.out.println(contaDao.buscarConta(4).toString());
	}

}
