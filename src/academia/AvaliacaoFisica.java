package academia;

import java.time.LocalDate;

public class AvaliacaoFisica {
	private LocalDate dataAvaliacao;
	private double peso;
	private double percentualGordura;
	private double percentualMusculo;
	
	public AvaliacaoFisica(double peso, double percentualGordura, double percentualMusculo) {
		this.dataAvaliacao = LocalDate.now();
		this.peso = peso;
		this.percentualGordura = percentualGordura;
		this.percentualMusculo = percentualMusculo;
	}

	public LocalDate getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(LocalDate dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPercentualGordura() {
		return percentualGordura;
	}

	public void setPercentualGordura(double percentualGordura) {
		this.percentualGordura = percentualGordura;
	}

	public double getPercentualMusculo() {
		return percentualMusculo;
	}

	public void setPercentualMusculo(double percentualMusculo) {
		this.percentualMusculo = percentualMusculo;
	}
	
	
}
