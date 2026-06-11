package agentes;

public class Aluno extends Pessoa{

	public Aluno() {
	}
	
	public Aluno(String nome, double cpf, int idade) {
		super(nome, cpf, idade);
		System.out.println("Aluno cadastrado com sucesso!");
	}
}
