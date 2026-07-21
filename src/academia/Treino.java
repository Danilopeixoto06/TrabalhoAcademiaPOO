package academia;

import java.util.ArrayList;
import java.util.List;

public class Treino {
    private String objetivo; 
    private Instrutor instrutorResponsavel;
    private List<Exercicio> exercicios;

    public Treino(String objetivo, Instrutor instrutorResponsavel) {
        this.objetivo = objetivo; //permite que o instrutor documente qual era a finalidade exata daquele conjunto de exercícios,sem precisar alterar o cadastro original do aluno.
        this.instrutorResponsavel = instrutorResponsavel;
        this.exercicios = new ArrayList<>();
    }

    // metodo para ir adicionando exercícios na ficha
    public void adicionarExercicio(Exercicio exercicio) {
        this.exercicios.add(exercicio);
    }

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Instrutor getInstrutorResponsavel() {
		return instrutorResponsavel;
	}

	public void setInstrutorResponsavel(Instrutor instrutorResponsavel) {
		this.instrutorResponsavel = instrutorResponsavel;
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}

   
}