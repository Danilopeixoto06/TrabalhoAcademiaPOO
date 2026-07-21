package academia;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa{
	private Plano plano;
	private String objetivo;
	private boolean inadimplente;
	private LocalDate dataMatricula;
	private Treino treinoAtual; 
	private List<AvaliacaoFisica> historicoAvaliacoes;
	
	
	//o objeto inadimplente não é passada como parametro pq se fosse passado o atendente sempre precisaria colocar false, sendo que ninguem é cadastrado e já está inadimplente
	public Aluno(String nome, int idade, Plano plano, String objetivo,AvaliacaoFisica primeiraAvaliacao) {
		super(nome,idade);
		this.plano=plano;
		this.objetivo = objetivo;
		this.inadimplente = false;
		this.dataMatricula = LocalDate.now(); // Grava a data em que o aluno foi matriculado
        this.historicoAvaliacoes = new ArrayList<>();
        // coloquei esse if para garantir que a alaviacao foi passada e evitar que adicionemos um objeto nulo, dando erro no main
        if (primeiraAvaliacao != null) {
        	this.historicoAvaliacoes.add(primeiraAvaliacao);
        }
        
	}
	
	public boolean podeFazerAvaliacao() {
		LocalDate hoje = LocalDate.now();
		
		// verifica se pode fazer a primeira avaliacao fisica
		if (this.historicoAvaliacoes.isEmpty()) {
			int mesesDesdeMatricula = (int) ChronoUnit.MONTHS.between(this.dataMatricula, hoje);
			return mesesDesdeMatricula>=1;
		}
		// pegamos a ultima avaliacao fisica feita, para poder comparar
		AvaliacaoFisica ultimaAvaliacao = this.historicoAvaliacoes.get(this.historicoAvaliacoes.size() - 1);
		
		// pegamos a data da ultima avaliacao fisica feita 
		LocalDate dataDaUltima = ultimaAvaliacao.getDataAvaliacao();

		// comparamos 
		int mesesDesdeUltima = (int) ChronoUnit.MONTHS.between(dataDaUltima, hoje);
		return mesesDesdeUltima>=1;
	}
		
	
	public void adicionarAvaliacao(AvaliacaoFisica avaliacao) {
		if(podeFazerAvaliacao()) {
			this.historicoAvaliacoes.add(avaliacao);
			System.out.println("Avaliação adicionada");
		}
		else {
		    System.out.println("Não foi possível adicionar, pois o aluno ainda nao completou um mês");
		}
	 }
	
	public void visualizarTreinoAtual() {
		if (this.treinoAtual == null) {
			System.out.println("O aluno " + this.getNome()+ " nao possui treino");
			return;
		}
		System.out.println("Treino de " +this.getNome() + " Objetivo: "+ this.treinoAtual.getObjetivo());
		
		
		for (Exercicio e : this.treinoAtual.getExercicios()) {
			System.out.println(e.getNome() + "|" + e.getSeries() + "x" + e.getRepeticoes());
		}
	}
	
	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public List<AvaliacaoFisica> getHistoricoAvaliacoes() {
		return historicoAvaliacoes;
	}

	public void setHistoricoAvaliacoes(List<AvaliacaoFisica> historicoAvaliacoes) {
		this.historicoAvaliacoes = historicoAvaliacoes;
	}
	
	public LocalDate getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(LocalDate dataMatricula) {
		this.dataMatricula = dataMatricula;
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
	public Treino getTreinoAtual() {
		return treinoAtual; 
	}
	public void setTreinoAtual(Treino treinoAtual) { 
		this.treinoAtual = treinoAtual; 
	}
	
}
