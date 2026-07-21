package academia;

import java.util.List;

public class Instrutor extends Funcionario{
	
	public Instrutor(String nome, int idade, double salario) {
		super(nome,idade, salario);
	}
	
	public void montarTreino(Aluno aluno, String objetivoTreino, List<Exercicio> listaDeExercicios) {
        System.out.println("O instrutor " + this.getNome() +" está montando o treino para " + aluno.getNome());
        
        //o this serve para passarmos o proprio instrutor como responsavel 
        Treino novoTreino = new Treino(objetivoTreino, this);
        
        // adiciona os exercícios enviados a lista do treino
        for (Exercicio ex : listaDeExercicios) {
            novoTreino.adicionarExercicio(ex);
        }
        
        // associamos esse treino diretamente ao cadastro do aluno
        aluno.setTreinoAtual(novoTreino);
        System.out.println("Treino associado ao aluno "+ aluno.getNome());
    }
	
	public void realizarAvaliacaoFisica(Aluno aluno, double peso, double percGord, double percMusc) {
	    AvaliacaoFisica novaAvaliacao = new AvaliacaoFisica(peso, percGord, percMusc);
	    aluno.adicionarAvaliacao(novaAvaliacao);
	}
	
	public void registrarManutencao(Equipamento equipamento) {
        equipamento.setEmManutencao(true);
        System.out.println("Equipamento "+ equipamento.getNome() +" em manutenção");
    }
	public void liberarEquipamento(Equipamento equipamento) {
        equipamento.setEmManutencao(false);
        System.out.println("Equipamento "+ equipamento.getNome() +" saiu da manutenção");
    }
	
	public void presenca(Aluno aluno, AulaExtra aula) {
        // O instrutor adiciona o aluno na lista de presença
        aula.adicionarPresencaAluno(aluno);
        System.out.println("Presença checada pelo instrutor " + this.getNome());
    }
	
	
}
