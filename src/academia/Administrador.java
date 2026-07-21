package academia;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends Pessoa {

    // lista com as unidades
    private List<Unidade> unidadesCadastradas;

    public Administrador(String nome, int idade) {
        super(nome, idade);
        this.unidadesCadastradas =new ArrayList<>();
    }

    // cria as unidades
    public Unidade cadastrarUnidade(String nome, String endereco) {
        Unidade novaUnidade =new Unidade(nome, endereco);
        this.unidadesCadastradas.add(novaUnidade);
        System.out.println("Unidade " + nome+ " cadastrada");
        return novaUnidade;
    }

    
    public void contratarAtendente(Unidade unidade, Atendente atendente) {
        unidade.adicionarAtendente(atendente);
        System.out.println("Atendente "+ atendente.getNome() + " contratado pela unidade "+ unidade.getNome());
    }

    public void contratarInstrutor(Unidade unidade, Instrutor instrutor) {
        unidade.adicionarInstrutor(instrutor);
        System.out.println("Instrutor " +instrutor.getNome()+ " contratado pela unidade "+ unidade.getNome());
    }

    public void demitirAtendente(Unidade unidade, Atendente atendente) {
        unidade.getAtendentes().remove(atendente);
        System.out.println("Atendente " + atendente.getNome() + " foi demitido da unidade " + unidade.getNome());
    }

    public void demitirInstrutor(Unidade unidade, Instrutor instrutor) {
        unidade.getInstrutores().remove(instrutor);
        System.out.println("Instrutor " + instrutor.getNome() + " foi demitido da " + unidade.getNome());
    }

    
    public void definirPrecoPlano(Plano plano, double novoValorBase) {
        plano.setValorBase(novoValorBase); 
        System.out.println("Novo valor base definido para os planos: " + novoValorBase);
    }

    public void setUnidadesCadastradas(List<Unidade> unidadesCadastradas) {
		this.unidadesCadastradas = unidadesCadastradas;
	}

	public List<Unidade> getUnidadesCadastradas() {
        return unidadesCadastradas;
    }
}