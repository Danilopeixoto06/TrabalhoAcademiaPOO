package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa{
	private String objetivo;
	private boolean inadimplente;
	private LocalDate dataMatricula;
	private Treino treinoAtual; 
	private List<AvaliacaoFisica> historicoAvaliacoes;
	
	//o objeto inadimplente não é passada como parametro pq se fosse passado o atendente sempre precisaria colocar false, sendo que ninguem é cadastrado e já está inadimplente
	public Aluno(String nome, String cpf, int idade, String objetivo) {
		super(nome, cpf, idade);
		this.objetivo = objetivo;
		this.inadimplente = false;
		this.dataMatricula = LocalDate.now(); // Grava a data em que o aluno foi matriculado
        this.historicoAvaliacoes = new ArrayList<>();
	}
	
	public void adicionarAvaliacao(AvaliacaoFisica avaliacao) {
        this.historicoAvaliacoes.add(avaliacao);
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
