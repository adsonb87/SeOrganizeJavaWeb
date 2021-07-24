package br.com.seorganizejavaweb.conta;

import java.util.ArrayList;

public class ControladorConta {

	private IRepositorioConta repositorioConta;
	
	public ControladorConta() {
		repositorioConta = new RepositorioContaJDBC();
	}
	
	public void cadastrarConta (Conta conta) {
		repositorioConta.cadastrarConta(conta);
	}
	public void alterarConta (Conta conta) {
		repositorioConta.alterarConta(conta);
	}
	
	public void salvarConta (Conta conta) {
		repositorioConta.salvarConta(conta);
	}
	
	public void excluirConta (Conta conta) {
		repositorioConta.excluirConta(conta);
	}
	
	public ArrayList<Conta> listarContas(){
		return repositorioConta.listarContas();
	}
	
	public ArrayList<Conta> listarContasUsuario(Integer id){
		return repositorioConta.listarContasUsuario(id);
	}
	
	public Conta buscarConta(Integer id) {
		return repositorioConta.buscarConta(id);
	}
	
}
