package br.com.seorganizejavaweb.lancamento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import br.com.seorganizejavaweb.conexao.Conexao;

public class RepositorioLancamentoJDBC implements IRepositorioLancamento {
	
	private Connection con = Conexao.getConnection();
	
	public void cadastrarLancamento (Lancamento lancamento) {
						
		String sql = "INSERT INTO LANCAMENTO (IDCONTA, TIPOLAN, CLASSELAN,"
				+ "DATAEMISSAO, DATAVENCIMENTO, STATUSLAN, DESCRICAO, VALOR) VALUES "
				+ "(?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement prStm = con.prepareStatement(sql);
			
			prStm.setInt(1, lancamento.getConta().getIdConta());
			prStm.setString(2, lancamento.getTipoLan().toString());
			prStm.setString(3, lancamento.getClassifLan().toString());
			prStm.setDate(4, lancamento.getDataEmissao());
			prStm.setDate(5, lancamento.getDataVencimento());
			prStm.setString(6, lancamento.getStatusLan().toString());
			prStm.setString(7, lancamento.getDescricaoLancamento());
			prStm.setDouble(8, lancamento.getValorLan());
			
			prStm.execute();
			prStm.close();
			
			System.out.println("Lancamento adicionado com sucesso!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterarLancamento (Lancamento lancamento) {
		
		String sql = "UPDATE LANCAMENTO SET IDCONTA = ?, TIPOLAN = ?, CLASSELAN = ?,"
				+ "DATAEMISSAO = ?, DATAVENCIMENTO = ?, STATUSLAN = ?,"
				+ "DESCRICAO = ?, VALOR = ? "
				+ "WHERE IDLAN = ?";
				 
		try {
			PreparedStatement prStm = con.prepareStatement(sql);
			
			prStm.setInt(1, lancamento.getConta().getIdConta());
			prStm.setString(2, lancamento.getTipoLan().toString());
			prStm.setString(3, lancamento.getClassifLan().toString());
			prStm.setDate(4, lancamento.getDataEmissao());
			prStm.setDate(5, lancamento.getDataVencimento());
			prStm.setString(6, lancamento.getStatusLan().toString());
			prStm.setString(7, lancamento.getDescricaoLancamento());
			prStm.setDouble(8, lancamento.getValorLan());
			prStm.setInt(9, lancamento.getIdLan());
			
			prStm.execute();
			prStm.close();
			
			System.out.println("Lançamento editado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void salvarLancamento (Lancamento lancamento) {
		if(lancamento.getIdLan()!= null && lancamento.getIdLan()!=0) {
			alterarLancamento(lancamento);
		}else {
			cadastrarLancamento(lancamento);
		}
	}
	
}
