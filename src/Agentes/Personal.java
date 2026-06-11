package agentes;

public class Personal extends Pessoa{

	public Personal() {
		// TODO Auto-generated constructor stub
	}
	
	public Personal(String nome, double cpf, int idade) {
		super(nome, cpf, idade);
		System.out.println("Personal cadastrado com sucesso!");
	}

}
