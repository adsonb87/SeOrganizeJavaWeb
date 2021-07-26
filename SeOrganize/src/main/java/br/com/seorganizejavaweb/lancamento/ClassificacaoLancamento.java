package br.com.seorganizejavaweb.lancamento;

public enum ClassificacaoLancamento {
	
	CREDITO("CREDITO"),
	DEBITO("DEBITO"),
	DINHEIRO("DINHEIRO");
	
	private String label;

	private ClassificacaoLancamento (String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
		
}
