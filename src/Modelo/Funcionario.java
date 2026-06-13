package Modelo;

//clasee abstract para evitar de criar alguem que não é funcionario ou atendente, pois pra isso ela precisa ter um salario
public abstract class Funcionario extends Pessoa{
	private double salario;
	
	public Funcionario (String nome, String cpf, int idade, double salario) {
		super(nome, cpf, idade);
		this.salario = salario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
