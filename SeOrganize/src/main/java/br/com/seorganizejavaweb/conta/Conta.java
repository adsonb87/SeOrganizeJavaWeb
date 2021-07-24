package br.com.seorganizejavaweb.conta;

import br.com.seorganizejavaweb.usuario.Usuario;

public class Conta {
	
	private Integer idConta;
	private Usuario usuario;
	private double saldoCredito;
	private double saldoDebito;
	private double saldoDinheiro;
	private double totalPagar;
	private double totalReceber;
	private String descricao;
	
	public Conta() {
		
	}

	public Integer getIdConta() {
		return idConta;
	}

	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double getSaldoCredito() {
		return saldoCredito;
	}

	public void setSaldoCredito(double saldoCredito) {
		this.saldoCredito = saldoCredito;
	}

	public double getSaldoDebito() {
		return saldoDebito;
	}

	public void setSaldoDebito(double saldoDebito) {
		this.saldoDebito = saldoDebito;
	}

	public double getSaldoDinheiro() {
		return saldoDinheiro;
	}

	public void setSaldoDinheiro(double saldoDinheiro) {
		this.saldoDinheiro = saldoDinheiro;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public double getTotalReceber() {
		return totalReceber;
	}

	public void setTotalReceber(double totalReceber) {
		this.totalReceber = totalReceber;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "Conta:\nIdConta: "+idConta+"\nidUsuario: "+usuario.getIdUsuario()+"\nDescricao: "+descricao+
				"\nSaldo Credito: "+saldoCredito+"\nSaldo Debito: "+saldoDebito+
				"\nSaldo Dinheiro: "+saldoDinheiro+"\nTotal a Pagar: "+totalPagar+
				"\nTotal a Receber: "+totalReceber;
	}
}
