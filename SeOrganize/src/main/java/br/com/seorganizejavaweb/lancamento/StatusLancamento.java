package br.com.seorganizejavaweb.lancamento;

public enum StatusLancamento {
	
	EMABERTO("EMABERTO"),
	PAGO("PAGO");
	
	private String label;
	
	private StatusLancamento(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
