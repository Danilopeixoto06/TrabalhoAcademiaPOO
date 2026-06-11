package agentes;

public class Academia {

	String nome;
	String endereco;
	String cep;
	int numeroAcademia;

	public Academia() {
		// TODO Auto-generated constructor stub
	}
	
	public Academia(String nome, String endereco, String cep, int numeroAcademia) {
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.numeroAcademia = numeroAcademia;
		System.out.println("Unidade cadastrada com sucesso!");
	}


}
