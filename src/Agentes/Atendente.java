package agentes;

public class Atendente extends Pessoa{

	public Atendente(Academia academia) {
		// TODO Auto-generated constructor stub
	}
	
	public Atendente(String nome, double cpf, int idade) {
		super(nome, cpf, idade);
		System.out.println("Atendente cadastrado com sucesso!");
	}

}
