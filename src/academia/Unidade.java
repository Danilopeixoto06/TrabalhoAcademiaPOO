package academia;

import java.util.ArrayList;
import java.util.List;

public class Unidade {
	private String nome;
	private String endereço;
	private List<Aluno> alunos;
	private List<Atendente> atendentes;
	private List<Instrutor> instrutores;
	private List<Equipamento> equipamentos;

	public Unidade(String nome, String endereco) {
		this.nome = nome;
		this.endereço = endereco;
		
		this.alunos = new ArrayList<>();
        this.atendentes = new ArrayList<>();
        this.instrutores = new ArrayList<>();
        this.equipamentos = new ArrayList<>();
	}
	public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void adicionarAtendente(Atendente atendente) {
        this.atendentes.add(atendente);
    }

    public void adicionarInstrutor(Instrutor instrutor) {
        this.instrutores.add(instrutor);
    }
    
    public void adicionarEquipamento(Equipamento equipamento) {
    	this.equipamentos.add(equipamento);
    }
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereço() {
		return endereço;
	}
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public List<Atendente> getAtendentes() {
		return atendentes;
	}
	public void setAtendentes(List<Atendente> atendentes) {
		this.atendentes = atendentes;
	}
	public List<Instrutor> getInstrutores() {
		return instrutores;
	}
	public void setInstrutores(List<Instrutor> instrutores) {
		this.instrutores = instrutores;
	}
	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}
	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}
    
	
	
	
}
