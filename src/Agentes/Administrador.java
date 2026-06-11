package agentes;

public class Administrador extends Pessoa{

	public Administrador(Academia academia) {
		// TODO Auto-generated constructor stub
	}
	
	public Administrador(String nome, double cpf, int idade) {
		super(nome, cpf, idade);
		System.out.println("Administrador cadastrado com sucesso!");	
	}

}
