package Modelo;

//classe do tipo abstract para evitar de criar alguem com nome, cpf e idade e não ser aluno, pra isso ele precisa de uma objetivo e peso
public abstract class Pessoa {
	//só mudei o tipo do cpf, tava como double, mas se o cpf começar com 0 o java iria pegar só os outros numeros e o zero não e tbm tem os pontos e o traço do final;
	private String nome;
	private String cpf;
	private int idade;
	
	public Pessoa(String nome, String cpf, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
