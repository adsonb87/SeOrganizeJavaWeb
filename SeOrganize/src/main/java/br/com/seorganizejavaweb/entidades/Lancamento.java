package br.com.seorganizejavaweb.entidades;

import java.util.Date;

public class Lancamento {
	
	private Integer idLan;
	private Integer idConta;
	private String tipoLan;
	private String classeLan;
	private double valorLan;
	private String statusLan;
	private Date dataEmissao;
	private Date dataVencimento;
	
	public Lancamento() {
	
	}

	public Integer getIdLan() {
		return idLan;
	}

	public void setIdLan(Integer idLan) {
		this.idLan = idLan;
	}

	public Integer getIdConta() {
		return idConta;
	}

	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}

	public String getTipoLancamento() {
		return tipoLan;
	}

	public void setTipoLan(String tipoLan) {
		this.tipoLan = tipoLan;
	}

	public String getClasseLan() {
		return classeLan;
	}

	public void setClasseLan(String classeLan) {
		this.classeLan = classeLan;
	}

	public double getValorLan() {
		return valorLan;
	}

	public void setValorLan(double valorLan) {
		this.valorLan = valorLan;
	}

	public String getStatusLan() {
		return statusLan;
	}

	public void setStatusLan(String statusLan) {
		this.statusLan = statusLan;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	@Override
	public String toString() {
		return "Lancamento:\nIdLan: "+idLan+"\nIdConta: "+idConta+"\nTipo: "+tipoLan+"\nValor: "+valorLan+
				"\nStatus: "+statusLan+"\nClassificacao: "+classeLan+"\nData Emissao: "+dataEmissao+
				"\nData Vencimento: "+dataVencimento;
	}
	
}
