package br.com.seorganizejavaweb.teste;

import br.com.seorganizejavaweb.conta.Conta;
import br.com.seorganizejavaweb.fachada.Fachada;
import br.com.seorganizejavaweb.lancamento.ClassificacaoLancamento;
import br.com.seorganizejavaweb.lancamento.Lancamento;
import br.com.seorganizejavaweb.lancamento.RepositorioLancamentoJDBC;
import br.com.seorganizejavaweb.lancamento.StatusLancamento;
import br.com.seorganizejavaweb.lancamento.TipoLancamento;

public class TesteLancamentoDAO {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setIdConta(2);
		
		Fachada f = Fachada.getInstance();
		
		f.calcularSaldos(conta);
		
	}
	
	private static void salvarLancamento () {
		Lancamento lan = new Lancamento();
		
		Fachada f = Fachada.getInstance();
		
		Conta conta = new Conta();
		conta.setIdConta(1);
		
		lan.setClassifLan(ClassificacaoLancamento.DINHEIRO);
		
		lan.setDataEmissao(java.sql.Date.valueOf("2021-07-24"));
		lan.setDataVencimento(java.sql.Date.valueOf("2021-08-15"));
		
		lan.setDescricaoLancamento("Fatura");
		lan.setConta(conta);
		lan.setStatusLan(StatusLancamento.PAGO);
		lan.setTipoLan(TipoLancamento.PAGAR);
		lan.setValorLan(500);

		
		f.salvarLancamento(lan);
	}

}
