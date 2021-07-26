package br.com.seorganizejavaweb.lancamento;

import java.util.ArrayList;

import br.com.seorganizejavaweb.conta.Conta;

public interface IRepositorioLancamento {

	public void cadastrarLancamento (Lancamento lancamento);
	public void alterarLancamento (Lancamento lancamento);
	public void salvarLancamento (Lancamento lancamento);
	public void excluirLancamento (Lancamento lancamento);
	public void alterarStatusLancamento (Lancamento lancamento);
	public Lancamento buscarLancamento (Integer id);
	public ArrayList<Lancamento> listarLancamentosUsuario (Integer id);
	public ArrayList<Lancamento> listarLacamentosConta (Integer id);
	
	
}
