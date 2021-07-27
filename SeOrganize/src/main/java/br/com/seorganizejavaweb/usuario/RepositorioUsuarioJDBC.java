package br.com.seorganizejavaweb.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.oracle.wls.shaded.org.apache.regexp.RE;

import br.com.seorganizejavaweb.conexao.Conexao;

public class RepositorioUsuarioJDBC implements IRepositorioUsuario{
	 
	private Connection con = Conexao.getConnection();
	
	public void cadastrarUsuario (Usuario user) {
		
		String sql = "INSERT INTO USUARIO (NOME, CPF, EMAIL, LOGIN, SENHA) VALUES (?,?,?,?,?)";
		
		try {
			PreparedStatement prStm = con.prepareStatement(sql);
			
			prStm.setString(1, user.getNome());
			prStm.setString(2, user.getCpf());
			prStm.setString(3, user.getEmail());
			prStm.setString(4, user.getLogin());
			prStm.setString(5, user.getSenha());
			
			prStm.execute();
			prStm.close();
			
			System.out.println("Cadastrado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterarUsuario (Usuario user) {
		
		String sql = "UPDATE USUARIO SET NOME = ?, CPF = ?, EMAIL = ?, LOGIN = ?, SENHA = ? WHERE IDUSUARIO = ?";
		
		try {
			PreparedStatement prStm = con.prepareStatement(sql);
			
			prStm.setString(1, user.getNome());
			prStm.setString(2, user.getCpf());
			prStm.setString(3, user.getEmail());
			prStm.setString(4, user.getLogin());
			prStm.setString(5, user.getSenha());
			prStm.setInt(6, user.getIdUsuario());
			
			prStm.execute();
			prStm.close();
			
			System.out.println("Alterado com sucesso!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void salvarUsuario (Usuario user) {
		if(user.getIdUsuario()!=null && user.getIdUsuario()!=0) {
			alterarUsuario(user);
		}else {
			cadastrarUsuario(user);
		}
	}
	
	public void excluirUsuario (Usuario user) {
		
		String sql = "DELETE FROM USUARIO WHERE IDUSUARIO = ?";
		
		try {
			PreparedStatement prStm = con.prepareStatement(sql);
			
			prStm.setInt(1, user.getIdUsuario());
			
			prStm.execute();
			prStm.close();
			
			System.out.println("Usuario excluido!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	public Usuario autenticarUsuario (Usuario user) {
		
		String sql = "SELECT * FROM USUARIO WHERE LOGIN = ? AND SENHA = ?";
		
		Usuario usuarioAutenticado = null;
		
		try {
			PreparedStatement prStm = con.prepareStatement(sql);
			
			prStm.setString(1, user.getLogin());
			prStm.setString(2, user.getSenha());
			
			ResultSet rs = prStm.executeQuery();
			
			if(rs.next()){
				usuarioAutenticado = new Usuario();
				usuarioAutenticado.setIdUsuario(rs.getInt("idusuario"));
				usuarioAutenticado.setNome(rs.getString("nome"));
				usuarioAutenticado.setEmail(rs.getString("email"));
				usuarioAutenticado.setCpf(rs.getString("cpf"));
				usuarioAutenticado.setLogin(rs.getString("login"));
				usuarioAutenticado.setSenha(rs.getString("senha"));
			}
			
			rs.close();
			prStm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
						
		return usuarioAutenticado;
	}
	
	public boolean existeUsuario (Usuario user) {
			
		String sql = "SELECT * FROM USUARIO WHERE LOGIN = ? AND SENHA = ?";
		
		boolean existe = false;
			
		try {
			PreparedStatement prStm = con.prepareStatement(sql);
			
			prStm.setString(1, user.getLogin());
			prStm.setString(2, user.getSenha());
			
			ResultSet rs = prStm.executeQuery();
			
			existe = rs.next();
				
			rs.close();
			prStm.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
							
		return existe;
	}

	@Override
	public Usuario buscarUsuarioID(Integer id) {
		Usuario usuario = null;
		
		String sql = "SELECT * FROM USUARIO WHERE IDUSUARIO = ?";
		
		try {
			PreparedStatement prStm = con.prepareStatement(sql);
			prStm.setInt(1, id);
			ResultSet rs = prStm.executeQuery();
			
			if(rs.next()) {
				usuario = new Usuario();
				usuario.setCpf(rs.getString("cpf"));
				usuario.setEmail(rs.getString("email"));
				usuario.setIdUsuario(rs.getInt("idusuario"));
				usuario.setLogin(rs.getString("login"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
			}
			
			prStm.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return usuario;
	}
	
	
}
