package modelo;

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
	public Aluno(String nome, int idade, Plano plano, String objetivo) {
		super(nome,idade);
		this.plano=plano;
		this.objetivo = objetivo;
		this.inadimplente = false;
		this.dataMatricula = LocalDate.now(); // Grava a data em que o aluno foi matriculado
        this.historicoAvaliacoes = new ArrayList<>();
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

	public void setDataMatricula(LocalDate dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	//getters e setters
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
	public LocalDate getDataMatricula() { 
		return dataMatricula;
	}
	
}
