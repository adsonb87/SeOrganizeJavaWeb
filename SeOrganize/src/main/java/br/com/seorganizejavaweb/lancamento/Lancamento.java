package br.com.seorganizejavaweb.lancamento;

import java.sql.Date;

import br.com.seorganizejavaweb.conta.Conta;

public class Lancamento {
	
	private Integer idLan;
	private Conta conta;
	private TipoLancamento tipoLan;
	private ClassificacaoLancamento classifLan;
	private double valorLan;
	private StatusLancamento statusLan;
	private Date dataEmissao;
	private Date dataVencimento;
	private String  descricaoLancamento;
	
		
	public Lancamento() {
	
	}
	
	

	public String getDescricaoLancamento() {
		return descricaoLancamento;
	}

	public void setDescricaoLancamento(String descricaoLancamento) {
		this.descricaoLancamento = descricaoLancamento;
	}

	public Integer getIdLan() {
		return idLan;
	}

	public void setIdLan(Integer idLan) {
		this.idLan = idLan;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta Conta) {
		this.conta = Conta;
	}

	public double getValorLan() {
		return valorLan;
	}

	public void setValorLan(double valorLan) {
		this.valorLan = valorLan;
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
	
	public TipoLancamento getTipoLan() {
		return tipoLan;
	}

	public void setTipoLan(TipoLancamento tipoLan) {
		this.tipoLan = tipoLan;
	}

	public ClassificacaoLancamento getClassifLan() {
		return classifLan;
	}

	public void setClassifLan(ClassificacaoLancamento classifLan) {
		this.classifLan = classifLan;
	}

	public StatusLancamento getStatusLan() {
		return statusLan;
	}

	public void setStatusLan(StatusLancamento statusLan) {
		this.statusLan = statusLan;
	}

	@Override
	public String toString() {
		return "Lancamento:\nIdLan: "+idLan+"\nIdConta: "+conta.getIdConta()+"\nTipo: "+tipoLan+"\nValor: "+valorLan+
				"\nStatus: "+statusLan+"\nClassificacao: "+classifLan+"\nData Emissao: "+dataEmissao+
				"\nData Vencimento: "+dataVencimento+"\nDescrição: "+descricaoLancamento;
	}
	
}
