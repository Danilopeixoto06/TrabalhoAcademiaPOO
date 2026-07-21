package academia;

import java.util.ArrayList;
import java.util.List;

public class AulaExtra {
	private String tipo;
	private int vagas;
	private final int LIMITE_MAXIMO = 30; 
	
	private List<Aluno> alunosInscritos;
	private List<Aluno> alunosPresentes;
	
	public AulaExtra (String tipo, int vagas) {
		this.tipo=tipo;
		this.setVagas(vagas); 
		this.alunosInscritos=new ArrayList<>();
		this.alunosPresentes=new ArrayList<>();
	}
	
	public void inscreverAluno(Aluno aluno) {
		if (this.alunosInscritos.size() < this.vagas) {
            this.alunosInscritos.add(aluno);
            System.out.println("Aluno " + aluno.getNome() + " foi inscrito na aula de " + this.tipo);   
        } else {
            System.out.println("Não há vagas disponíveis para " + this.tipo);
        }
	}
	

	public void adicionarPresencaAluno(Aluno aluno) {
		if (this.alunosInscritos.contains(aluno)) {
            if (!this.alunosPresentes.contains(aluno)) {
                this.alunosPresentes.add(aluno);
                System.out.println("O aluno " + aluno.getNome() + " esta presente na aula de " + this.tipo);
            } else {
                System.out.println("A presença de " + aluno.getNome() + " já foi registrada anteriormente");
            }
        } else {
            System.out.println("O aluno " + aluno.getNome() + " não estava inscrito na aula");
        }
	}
	
	public List<Aluno> getAlunosInscritos() {
		return alunosInscritos;
	}

	public void setAlunosInscritos(List<Aluno> alunosInscritos) {
		this.alunosInscritos = alunosInscritos;
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