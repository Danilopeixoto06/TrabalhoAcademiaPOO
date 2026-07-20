package modelo;

import java.util.ArrayList;
import java.util.List;

public class AulaExtra {
	private String tipo;
	private int vagas;
	private final int LIMITE_MAXIMO = 30; 
	
	private List<Aluno> alunosPresentes;
	
	public AulaExtra (String tipo, int vagas) {
		this.tipo=tipo;
		this.setVagas(vagas); 
		this.alunosPresentes=new ArrayList<>();
	}
	
	public void adicionarPresencaAluno(Aluno aluno) {
		if (this.alunosPresentes.size() <this.vagas) {
            this.alunosPresentes.add(aluno);
        } else {
            System.out.println("Não há vagas disponíveis.");
        }
	}
	
	public List<Aluno> getAlunosPresentes() {
		return alunosPresentes;
	}

	public void setAlunosPresentes(List<Aluno> alunosPresentes) {
		this.alunosPresentes = alunosPresentes;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
        if (vagas >= 0 && vagas <= LIMITE_MAXIMO) {
            this.vagas = vagas;
        } else {
            System.out.println("Erro pois o limite da sala é de " + LIMITE_MAXIMO + " pessoas.");
        }
    }
}