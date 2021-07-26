package br.com.seorganizejavaweb.conta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioConta {
	
	public void cadastrarConta (Conta conta);
	public void alterarConta (Conta conta);
	public void salvarConta (Conta conta);
	public void excluirConta (Conta conta);
	public ArrayList<Conta> listarContasUsuario(Integer id);
	public Conta buscarConta(Integer id);
	public void calcularSaldos (Conta conta);
		
}
