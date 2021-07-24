package br.com.seorganizejavaweb.lancamento;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface IRepositorioLancamento {

	public void cadastrarLancamento (Lancamento lancamento);
	public void alterarLancamento (Lancamento lancamento);
	public void salvarLancamento (Lancamento lancamento);
	
}
