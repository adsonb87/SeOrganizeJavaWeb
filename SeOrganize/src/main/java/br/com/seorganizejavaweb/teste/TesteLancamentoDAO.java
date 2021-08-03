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
		
		Fachada f = Fachada.getInstance();
		Conta conta = new Conta();
		conta.setIdConta(1);
		Conta conta2 = new Conta();
		conta2.setIdConta(2);
		f.calcularSaldos(conta);
		f.calcularSaldos(conta2);
				
	}
	
	private static void salvarLancamento () {
		Lancamento lan = new Lancamento();
		
		Fachada f = Fachada.getInstance();
		
		Conta conta = new Conta();
		conta.setIdConta(2);
		
		lan.setClassifLan(ClassificacaoLancamento.DEBITO);
		
		lan.setDataEmissao(java.sql.Date.valueOf("2021-08-03"));
		lan.setDataVencimento(java.sql.Date.valueOf("2021-08-03"));
		
		lan.setDescricaoLancamento("Lanche");
		lan.setConta(conta);
		lan.setStatusLan(StatusLancamento.PAGO);
		lan.setTipoLan(TipoLancamento.PAGAR);
		lan.setValorLan(100);

		
		f.salvarLancamento(lan);
		
	}
	
	private static void listarLancamentosUsuario() {
		RepositorioLancamentoJDBC r = new RepositorioLancamentoJDBC();
		
		System.out.println(r.listarLancamentosUsuario(6).toString());
	}
	
	private static void listarLancamentosConta() {
		RepositorioLancamentoJDBC r = new RepositorioLancamentoJDBC();
		
		System.out.println(r.listarLacamentosConta(2).toString());
	}

}
