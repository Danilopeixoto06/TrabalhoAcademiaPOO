package academia;

public class Atendente extends Funcionario{
	
	public Atendente(String nome, int idade, double salario) {
		super(nome,idade,salario);
	}
	
	public Aluno realizarMatricula(Unidade unidade,double valor, String nome, int idade, String objetivo,double peso,double percGord, double percMusc) {

		Plano planoM = new PlanoMensal();
		Plano planoS = new PlanoSemestral();
		Plano planoA = new PlanoAnual();
		Plano planoEsc = null;
		
        if (valor== planoM.calcularMensalidade() * planoM.getValidadeMeses()) {
            planoEsc = planoM;
        } 
        else if (valor== planoS.calcularMensalidade() * planoS.getValidadeMeses()) {
            planoEsc = planoS;
        } 
        else if (valor== planoA.calcularMensalidade() * planoA.getValidadeMeses()) {
            planoEsc = planoA;
        } 
        else {
            System.out.println("O valor " + valor + " não corresponde a nenhum plano");
            return null; 
        }
        
        AvaliacaoFisica primeiraAvaliacao = new AvaliacaoFisica(peso,percGord,percMusc);
        
        Aluno novoAluno = new Aluno(nome, idade, planoEsc, objetivo, primeiraAvaliacao);
        unidade.adicionarAluno(novoAluno);
        System.out.println("Aluno " +nome+" adicionado à unidade "+ unidade.getNome() + " pelo atendente " + this.getNome());
        return novoAluno;
    }
	
}
