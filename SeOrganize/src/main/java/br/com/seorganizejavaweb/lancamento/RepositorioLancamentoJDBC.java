package br.com.seorganizejavaweb.lancamento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import br.com.seorganizejavaweb.conexao.Conexao;
import br.com.seorganizejavaweb.conta.Conta;

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
			
			System.out.println("Lan�amento editado com sucesso!");
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

	@Override
	public void excluirLancamento(Lancamento lancamento) {
		
		String sql = "DELETE FROM LANCAMENTO WHERE IDLAN = ?";
		
		try {
			PreparedStatement prStm = con.prepareStatement(sql);
			
			prStm.setInt(1, lancamento.getIdLan());
			
			prStm.execute();
			prStm.close();
			
			System.out.println("Lancamento exclu�do!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterarStatusLancamento(Lancamento lancamento) {
		
		String sql = "UPDATE LANCAMENTO SET STATUSLAN = 'PAGO' WHERE IDLAN =?";
		
		try {
			PreparedStatement prStm = con.prepareStatement(sql);
			
			prStm.setInt(1, lancamento.getIdLan());
			
			prStm.execute();
			prStm.close();
			
			System.out.println("Lancamento pago!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Lancamento buscarLancamento(Integer id) {

		String sql = "SELECT * FROM LANCAMENTO WHERE IDLAN = ?";
				
		try {
			PreparedStatement prStm = con.prepareStatement(sql);
			prStm.setInt(1, id);
			
			ResultSet rs = prStm.executeQuery();
			
			if(rs.next()) {
				Lancamento lancamento = new Lancamento();
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	@Override
	public ArrayList<Lancamento> listarLancamentosUsuario(Integer id) {
		
		String sql = "SELECT * FROM LANCAMENTO"
				+ "INNER JOIN CONTA ON LANCAMENTO.idconta = CONTA.idconta"
				+ "INNER JOIN USUARIO ON USUARIO.idusuario = CONTA.idusuario"
				+ "WHERE USUARIO.idusuario = ?";
		
		return null;
	}

	@Override
	public ArrayList<Lancamento> listarLacamentosConta(Integer id) {
		
		String sql = "SELECT * FROM LANCAMENTO'"
				+ "INNER JOIN CONTA ON LANCAMENTO.idconta = CONTA.idconta"
				+ "WHERE CONTA.IDCONTA = ?";
		
		return null;
	}
	
}
