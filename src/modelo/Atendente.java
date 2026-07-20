package modelo;

public class Atendente extends Funcionario{
	
	public Atendente(String nome, int idade, double salario) {
		super(nome,idade,salario);
	}
	
	public Aluno realizarMatricula(Unidade unidade,double valor, String nome, int idade, String objetivo) {
        Plano plano = null;
        if (valor==100.0) {
            plano =new PlanoMensal();
        } 
        else if (valor==540.0) {
            plano =new PlanoSemestral();
        } 
        else if (valor==960.0) {
            plano =new PlanoAnual();
        } 
        else {
            System.out.println("O valor " + valor + " não corresponde a nenhum plano");
            return null; 
        }
        Aluno novoAluno = new Aluno(nome, idade, plano, objetivo);
        unidade.adicionarAluno(novoAluno);
        System.out.println("Aluno " +nome+" adicionado à unidade "+ unidade.getNome());
        return novoAluno;
    }
	
}
