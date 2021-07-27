package br.com.seorganizejavaweb.lancamento;

import java.util.ArrayList;

public class ControladorLancamento {
	
	private IRepositorioLancamento repositorioLancamento;
	
	public ControladorLancamento() {
		repositorioLancamento = new RepositorioLancamentoJDBC();
	}
	
	public void cadastrarLancamento (Lancamento lancamento) {
		repositorioLancamento.cadastrarLancamento(lancamento);
	}
	
	public void alterarLancamento (Lancamento lancamento) {
		repositorioLancamento.alterarLancamento(lancamento);
	}
	
	public void salvarLancamento (Lancamento lancamento) {
		repositorioLancamento.salvarLancamento(lancamento);		
	}
	
	public void excluirLancamento (Lancamento lancamento) {
		repositorioLancamento.excluirLancamento(lancamento);
	}
	
	public void alterarStatusLancamento (Lancamento lancamento) {
		repositorioLancamento.alterarStatusLancamento(lancamento);
	}
	
	public Lancamento buscarLancamento (Integer id) {
		return repositorioLancamento.buscarLancamento(id);
	}
	
	public ArrayList<Lancamento> listarLancamentosUsuario (Integer id){
		return repositorioLancamento.listarLancamentosUsuario(id);
	}
	
	public ArrayList<Lancamento> listarLacamentosConta (Integer id){
		return repositorioLancamento.listarLacamentosConta(id);
	}
	
}
