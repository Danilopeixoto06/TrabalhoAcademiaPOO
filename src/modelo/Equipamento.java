package modelo;

public class Equipamento {
	private String nome;
	private boolean emManutencao;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isEmManutencao() {
		return emManutencao;
	}

	public void setEmManutencao(boolean emManutencao) {
		this.emManutencao = emManutencao;
	}

	public Equipamento(String nome) {
		this.nome = nome;
		this.emManutencao = false;
	}
	
	
}
