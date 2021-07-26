package br.com.seorganizejavaweb.conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.seorganizejavaweb.conexao.Conexao;
import br.com.seorganizejavaweb.usuario.Usuario;

public class RepositorioContaJDBC implements IRepositorioConta {

	private Connection con = Conexao.getConnection();
	
	public void cadastrarConta (Conta conta) {
		
		String sql = "INSERT INTO CONTA (IDUSUARIO, SALDOCREDITO, SALDODEBITO,"
				+ "SALDODINHEIRO, TOTALPAGAR, TOTALRECEBER, DESCRICAO) "
				+ "VALUES (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement prStm = con.prepareStatement(sql);
			
			prStm.setInt(1, conta.getUsuario().getIdUsuario());
			prStm.setDouble(2, conta.getSaldoCredito());
			prStm.setDouble(3, conta.getSaldoDebito());
			prStm.setDouble(4, conta.getSaldoDinheiro());
			prStm.setDouble(5, conta.getTotalPagar());
			prStm.setDouble(6, conta.getTotalReceber());
			prStm.setString(7, conta.getDescricao());
			
			prStm.execute();
			prStm.close();
			
			System.out.println("Conta cadastrada");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alterarConta (Conta conta) {
		
		String sql = "UPDATE CONTA SET IDUSUARIO = ?, SALDOCREDITO = ?, SALDODEBITO = ?,"
				+ "SALDODINHEIRO = ?, TOTALPAGAR = ?, TOTALRECEBER = ?, DESCRICAO = ?"
				+ "WHERE IDCONTA = ?";
		
		try {
			PreparedStatement prStm = con.prepareStatement(sql);
			
			prStm.setInt(1, conta.getUsuario().getIdUsuario());
			prStm.setDouble(2, conta.getSaldoCredito());
			prStm.setDouble(3, conta.getSaldoDebito());
			prStm.setDouble(4, conta.getSaldoDinheiro());
			prStm.setDouble(5, conta.getTotalPagar());
			prStm.setDouble(6, conta.getTotalReceber());
			prStm.setString(7, conta.getDescricao());
			prStm.setInt(8, conta.getIdConta());
			
			prStm.execute();
			prStm.close();
			
			System.out.println("Conta Atualizada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void salvarConta (Conta conta) {
		if(conta.getIdConta()!= null && conta.getIdConta()!=0) {
			alterarConta(conta);
		}else {
			cadastrarConta(conta);
		}
	}
	
	public void excluirConta (Conta conta) {
		
		String sql = "DELETE FROM CONTA WHERE IDCONTA = ?";
		
		try {
			PreparedStatement prStm = con.prepareStatement(sql);
			
			prStm.setInt(1, conta.getIdConta());
			
			prStm.execute();
			prStm.close();
			
			System.out.println("Conta excluida!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Conta> listarContas() {
		
		ArrayList<Conta> listaContas = new ArrayList<Conta>();
		
		String sql = "SELECT * FROM CONTA ORDER BY IDCONTA";
		
		try {
			PreparedStatement prStm = con.prepareStatement(sql);
			
			ResultSet rs = prStm.executeQuery();
			
			while(rs.next()) {
				
				Conta conta = new Conta();
				Usuario usuario = new Usuario();
				
				conta.setIdConta(rs.getInt("idconta"));
				usuario.setIdUsuario(rs.getInt("idusuario"));
				conta.setUsuario(usuario);
				conta.setSaldoCredito(rs.getDouble("saldocredito"));
				conta.setSaldoDebito(rs.getDouble("saldodebito"));
				conta.setSaldoDinheiro(rs.getDouble("saldodinheiro"));
				conta.setTotalPagar(rs.getDouble("totalpagar"));
				conta.setTotalReceber(rs.getDouble("totalreceber"));
				conta.setDescricao(rs.getString("descricao"));
				
				listaContas.add(conta);
			}
			
			rs.close();
			prStm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaContas;
	}
	
	public ArrayList<Conta> listarContasUsuario(Integer id) {
			
			ArrayList<Conta> listaContas = new ArrayList<Conta>();
			
			String sql = "SELECT * FROM CONTA INNER JOIN USUARIO "
					+ "ON CONTA.IDUSUARIO = USUARIO.IDUSUARIO "
					+ "WHERE CONTA.IDUSUARIO = ?"
					+ "ORDER BY IDCONTA";
			
			try {
				PreparedStatement prStm = con.prepareStatement(sql);
				
				prStm.setInt(1, id);
				
				ResultSet rs = prStm.executeQuery();
				
				while(rs.next()) {
					
					Conta conta = new Conta();
					Usuario usuario = new Usuario();
					
					conta.setIdConta(rs.getInt("idconta"));
					usuario.setIdUsuario(rs.getInt("idusuario"));
					conta.setUsuario(usuario);
					conta.setSaldoCredito(rs.getDouble("saldocredito"));
					conta.setSaldoDebito(rs.getDouble("saldodebito"));
					conta.setSaldoDinheiro(rs.getDouble("saldodinheiro"));
					conta.setTotalPagar(rs.getDouble("totalpagar"));
					conta.setTotalReceber(rs.getDouble("totalreceber"));
					conta.setDescricao(rs.getString("descricao"));
					
					listaContas.add(conta);
				}
				
				rs.close();
				prStm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return listaContas;
		}
	
	public Conta buscarConta(Integer id) {
		
		Conta conta = null;
		Usuario usuario = null;
		
		String sql = "SELECT * FROM CONTA INNER JOIN USUARIO "
				+ "ON CONTA.IDUSUARIO = USUARIO.IDUSUARIO "
				+ "WHERE CONTA.IDCONTA = ?"
				+ "ORDER BY IDCONTA";
		
		try {
			PreparedStatement prStm = con.prepareStatement(sql);
			
			prStm.setInt(1, id);
			
			ResultSet rs = prStm.executeQuery();
			
			if(rs.next()) {
				
				conta = new Conta();
				usuario = new Usuario();
				
				conta.setIdConta(rs.getInt("idconta"));
				usuario.setIdUsuario(rs.getInt("idusuario"));
				conta.setUsuario(usuario);
				conta.setSaldoCredito(rs.getDouble("saldocredito"));
				conta.setSaldoDebito(rs.getDouble("saldodebito"));
				conta.setSaldoDinheiro(rs.getDouble("saldodinheiro"));
				conta.setTotalPagar(rs.getDouble("totalpagar"));
				conta.setTotalReceber(rs.getDouble("totalreceber"));
				conta.setDescricao(rs.getString("descricao"));
			}
			
			rs.close();
			prStm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conta;
	}

	@Override
	public void calcularSaldos(Conta conta) {
		
		String sql = "UPDATE CONTA\r\n"
				+ "SET SALDOCREDITO = (SELECT SUM(LANCAMENTO.VALOR)"
				+ "					FROM CONTA"
				+ "					INNER JOIN LANCAMENTO"
				+ "							ON LANCAMENTO.idconta = CONTA.idconta"
				+ "					WHERE LANCAMENTO.CLASSELAN = 'CREDITO'"
				+ "					  AND CONTA.idconta = ?),"
				+ "	SALDODEBITO  = (SELECT SUM(LANCAMENTO.VALOR)"
				+ "					FROM CONTA"
				+ "					INNER JOIN LANCAMENTO"
				+ "							ON LANCAMENTO.idconta = CONTA.idconta"
				+ "					WHERE LANCAMENTO.CLASSELAN = 'DEBITO'"
				+ "					  AND CONTA.idconta = ?),"
				+ "	SALDODINHEIRO = (SELECT SUM(LANCAMENTO.VALOR)"
				+ "					 FROM CONTA"
				+ "					 INNER JOIN LANCAMENTO"
				+ "					  		 ON LANCAMENTO.idconta = CONTA.idconta"
				+ "					 WHERE LANCAMENTO.CLASSELAN = 'DINHEIRO'"
				+ "					   AND CONTA.idconta = ?),"
				+ "	TOTALPAGAR = (SELECT SUM(LANCAMENTO.VALOR)"
				+ "				  FROM CONTA"
				+ "				  INNER JOIN LANCAMENTO"
				+ "					   	  ON LANCAMENTO.idconta = CONTA.idconta"
				+ "				  WHERE LANCAMENTO.TIPOLAN = 'PAGAR'"
				+ "					AND CONTA.idconta = ?),"
				+ "	TOTALRECEBER = (SELECT SUM(LANCAMENTO.VALOR)"
				+ "					FROM CONTA"
				+ "					INNER JOIN LANCAMENTO"
				+ "							ON LANCAMENTO.idconta = CONTA.idconta"
				+ "					WHERE LANCAMENTO.TIPOLAN = 'RECEBER'"
				+ "					  AND CONTA.idconta = ?)"
				+ "WHERE IDCONTA = ?";
		
		try {
			PreparedStatement prStm = con.prepareStatement(sql);
			
			prStm.setInt(1, conta.getIdConta());
			prStm.setInt(2, conta.getIdConta());
			prStm.setInt(3, conta.getIdConta());
			prStm.setInt(4, conta.getIdConta());
			prStm.setInt(5, conta.getIdConta());
			prStm.setInt(6, conta.getIdConta());
			
			prStm.execute();
			prStm.close();
			
			System.out.println("Saldos alterados!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
