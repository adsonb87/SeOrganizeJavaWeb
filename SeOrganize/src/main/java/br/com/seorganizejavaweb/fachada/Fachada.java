package br.com.seorganizejavaweb.fachada;

import java.util.ArrayList;

import br.com.seorganizejavaweb.conta.Conta;
import br.com.seorganizejavaweb.conta.ControladorConta;
import br.com.seorganizejavaweb.lancamento.ControladorLancamento;
import br.com.seorganizejavaweb.lancamento.Lancamento;
import br.com.seorganizejavaweb.usuario.ControladorUsuario;
import br.com.seorganizejavaweb.usuario.Usuario;

public class Fachada {
	
	private ControladorUsuario controladorUsuario;
	private ControladorConta controladorConta;
	private ControladorLancamento controladorLancamento;
	
	private static Fachada fachada;
	
	public static Fachada getInstance() {
		if(fachada == null) {
			fachada = new Fachada();
		}
		return fachada;
	}
	
	private Fachada() {
		controladorUsuario = new ControladorUsuario();
		controladorConta = new ControladorConta();
		controladorLancamento = new ControladorLancamento();
	}
	
	//Metodos usuario
	
	public void cadastrarUsuario (Usuario user) {
		controladorUsuario.cadastrarUsuario(user);
	}
	
	public void alterarUsuario (Usuario user) {
		controladorUsuario.alterarUsuario(user);
	}
	
	public void salvarUsuario (Usuario user) {
		controladorUsuario.salvarUsuario(user);
	}
	
	public void excluirUsuario (Usuario user) {
		controladorUsuario.excluirUsuario(user);
	}
		
	public Usuario autenticarUsuario (Usuario user) {
		return controladorUsuario.autenticarUsuario(user);
	}
	
	public boolean existeUsuario (Usuario user) {
		return controladorUsuario.existeUsuario(user);
	}
	
	//Metodos Conta
	
	public void cadastrarConta (Conta conta) {
		controladorConta.cadastrarConta(conta);
	}
	public void alterarConta (Conta conta) {
		controladorConta.alterarConta(conta);
	}
	
	public void salvarConta (Conta conta) {
		controladorConta.salvarConta(conta);
	}
	
	public void excluirConta (Conta conta) {
		controladorConta.excluirConta(conta);
	}
	
	public ArrayList<Conta> listarContasUsuario(Integer id){
		return controladorConta.listarContasUsuario(id);
	}
	
	public Conta buscarConta(Integer id) {
		return controladorConta.buscarConta(id);
	}
	
	public void calcularSaldos (Conta conta) {
		controladorConta.calcularSaldos(conta);
	}
	
	
	//Metodos Lancamento
	
	public void cadastrarLancamento (Lancamento lancamento) {
		controladorLancamento.cadastrarLancamento(lancamento);
	}
	
	public void alterarLancamento (Lancamento lancamento) {
		controladorLancamento.alterarLancamento(lancamento);
	}
	
	public void salvarLancamento (Lancamento lancamento) {
		controladorLancamento.salvarLancamento(lancamento);		
	}
	
	public void excluirLancamento (Lancamento lancamento) {
		controladorLancamento.excluirLancamento(lancamento);
	}
	
	public void alterarStatusLancamento (Lancamento lancamento) {
		controladorLancamento.alterarStatusLancamento(lancamento);
	}
	
	public Lancamento buscarLancamento (Integer id) {
		return controladorLancamento.buscarLancamento(id);
	}
	
	public ArrayList<Lancamento> listarLancamentosUsuario (Integer id){
		return controladorLancamento.listarLancamentosUsuario(id);
	}
	
	public ArrayList<Lancamento> listarLacamentosConta (Integer id){
		return controladorLancamento.listarLacamentosConta(id);
	}
	
	
}
