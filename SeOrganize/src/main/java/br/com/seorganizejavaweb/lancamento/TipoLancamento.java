package br.com.seorganizejavaweb.lancamento;

public enum TipoLancamento {

	PAGAR("PAGAR"),
	RECEBER("RECEBER");
	
	private String label;
	
	private TipoLancamento(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
