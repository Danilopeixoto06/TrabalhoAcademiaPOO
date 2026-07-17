package main;

import modelo.Aluno;
import modelo.Atendente;
import modelo.AulaExtra;
import modelo.AvaliacaoFisica;
import modelo.Equipamento;
import modelo.Exercicio;
import modelo.Instrutor;
import modelo.Plano;
import modelo.PlanoAnual;
import modelo.PlanoMensal;
import modelo.Treino;
import modelo.Unidade;
import servicos.AgendamentoServico;
import servicos.FinanceiroServico;

public class Main {
    public static void main(String[] args) {

        // criando unidade e funcionários
        Unidade unidadeCentro = new Unidade("Academia Fit - Matriz", "Rua Principal, 123");
        Atendente atendente = new Atendente("Maria Recepcionista", "111.111.111-11", 25, 1500.0);
        Instrutor instrutor = new Instrutor("Carlos Personal", "222.222.222-22", 30, 2500.0);

        unidadeCentro.getAtendentes().add(atendente);
        unidadeCentro.getInstrutores().add(instrutor);

        // cadastrando o aluno e a 1° avaliação física
        System.out.println("Atendente " + atendente.getNome() + " está matriculando um novo aluno");
        Aluno alunoJoao = new Aluno("João Silva", "333.333.333-33", 28, "hipertrofia");
        unidadeCentro.getAlunos().add(alunoJoao);

        AvaliacaoFisica avaliacaoInicial = new AvaliacaoFisica(80.5, 18.5, 42.0);
        alunoJoao.adicionarAvaliacao(avaliacaoInicial);

        FinanceiroServico financeiro = new FinanceiroServico();
        Plano planoJoao = new PlanoAnual(); 
        
        financeiro.processarPagamento(alunoJoao, planoJoao, true);

        // O treino 
        System.out.println("\n---Montando a Ficha de Treino ---");
        Treino treinoJoao = new Treino("Adaptação e Força", instrutor);
        
        // Adicionando exercícios soltos dentro do treino
        treinoJoao.adicionarExercicio(new Exercicio("Supino Reto", 3, 12));
        treinoJoao.adicionarExercicio(new Exercicio("Agachamento Livre", 4, 10));
        treinoJoao.adicionarExercicio(new Exercicio("Esteira", 1, 20)); 
        
        // relacionando o treino ao aluno
        alunoJoao.setTreinoAtual(treinoJoao);
        System.out.println("Treino montado pelo instrutor " + alunoJoao.getTreinoAtual().getInstrutorResponsavel().getNome() + " com " + alunoJoao.getTreinoAtual().getExercicios().size() + " exercícios.");

        // 5. Agendamento de Aula Extra
        AulaExtra aulaPilates = new AulaExtra("Pilates", 30); // Limite de 30 vagas configurado lá na classe
        AgendamentoServico agendamento = new AgendamentoServico();
        
        // verificando vagas e matricula
        agendamento.matricularEmAula(alunoJoao, aulaPilates);
        
        // --- TESTES DAS FUNCIONALIDADES RESTANTES ---

        System.out.println("\n---Teste de Equipamentos---");
        Equipamento extensora = new Equipamento("Extensora LIFE");
        unidadeCentro.getEquipamentos().add(extensora);
        
        System.out.println("O equipamento " + extensora.getNome() + " está funcionando?");
        // O instrutor verifica o estado da maquina
        extensora.setEmManutencao(true);
        System.out.println("Estado atualizado: Em manutenção? " + extensora.isEmManutencao());


        System.out.println("\n---Teste de Turma Lotada---");
        AulaExtra aulaCrossfit = new AulaExtra("Crossfit", 0); // Simulando uma turma já cheia!
        agendamento.matricularEmAula(alunoJoao, aulaCrossfit);


        System.out.println("\n---Teste de Pagamento Recusado e Outro Plano---");
        // Criando a aluna Maria com um plano diferente (Mensal, sem os 20% de desconto)
        Aluno alunaMaria = new Aluno("Maria Santos", "444.444.444-44", 22, "emagrecimento");
        Plano planoMaria = new PlanoMensal(); 
        
        // A Maria tentou pagar, mas o cartão deu erro 
        financeiro.processarPagamento(alunaMaria, planoMaria, false);
    }
}