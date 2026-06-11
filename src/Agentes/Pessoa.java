package agentes;

public abstract class Pessoa {
	private String nome;
	private double cpf;
	private int idade;
	private int peso;
	
	public Pessoa() {}
	
	public Pessoa(String nome, double cpf, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}
}
