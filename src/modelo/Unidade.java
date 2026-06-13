package modelo;

import java.util.ArrayList;
import java.util.List;

public class Unidade {
	private String nome;
	private String endereço;
	// Listas para armazenar as pessoas que pertencem a esta unidade
	private List<Aluno> alunos;
	private List<Atendente> atendentes;
	private List<Instrutor> instrutores;
	private List<Equipamento> equipamentos;

	public Unidade(String nome, String endereco) {
		this.nome = nome;
		this.endereço = endereco;
		// Inicialização das listas
		this.alunos = new ArrayList<>();
        this.atendentes = new ArrayList<>();
        this.instrutores = new ArrayList<>();
        this.equipamentos = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}

	public String getEndereço() {
		return endereço;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public List<Atendente> getAtendentes() {
		return atendentes;
	}

	public List<Instrutor> getInstrutores() {
		return instrutores;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}
	
}
