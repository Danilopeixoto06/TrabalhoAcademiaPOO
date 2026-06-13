package modelo;

public class Aluno extends Pessoa{
	private double peso;
	private String objetivo;
	private boolean inadimplente;
	
	//o obejto inadimplente não é passada como parametro pq se fosse passado o atendente sempre precisaria colocar false, sendo que ninguem é cadastrado e já está inadimplente
	public Aluno(String nome, String cpf, int idade, double peso, String objetivo) {
		super(nome, cpf, idade);
		this.peso = peso;
		this.objetivo = objetivo;
		this.inadimplente = false;
	}
	
	//getters e setters
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public boolean isInadimplente() {
		return inadimplente;
	}

	public void setInadimplente(boolean inadimplente) {
		this.inadimplente = inadimplente;
	}
	
}
