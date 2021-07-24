package br.com.seorganizejavaweb.lancamento;

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
	
}
