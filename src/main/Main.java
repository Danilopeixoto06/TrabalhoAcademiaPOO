package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import academia.Administrador;
import academia.Aluno;
import academia.Atendente;
import academia.AulaExtra;
import academia.Equipamento;
import academia.Exercicio;
import academia.Instrutor;
import academia.Plano;
import academia.PlanoAnual;
import academia.PlanoMensal;
import academia.Unidade;
import sistema.Financeiro;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("Iniciando teste");
        System.out.println();

        System.out.println("Criando um administrador");
        System.out.println();
        Administrador admin = new Administrador("Administrador Joao", 45);
        System.out.println("Administrador cria a unidade UFCAFIT");
        
        Unidade unidadeCentro = admin.cadastrarUnidade("UFCAFIT", "Rua das cadeiras 123");
        
        System.out.println("Definindo o preço dos planos");
        Plano planoMensal = new PlanoMensal();
        admin.definirPrecoPlano(planoMensal, 100.0);
        System.out.println();

        System.out.println("Contratando funcionários");
        Atendente atendente1 = new Atendente("Mariana", 20, 1600.0);
        Instrutor instrutor1 = new Instrutor("Roberto", 25, 3000.0);

        admin.contratarAtendente(unidadeCentro, atendente1);
        admin.contratarInstrutor(unidadeCentro, instrutor1);
        System.out.println();

        System.out.println("Matrícula do aluno pelo atendente");
        Aluno aluno1 = atendente1.realizarMatricula(unidadeCentro,100.0,"Lucas",22,"Hipertrofia",75.5,10.0,40.0);
        Aluno aluno2 = atendente1.realizarMatricula(unidadeCentro, 540.0, "Ana", 20, "Emagrecimento", 90.0, 25.0, 20.0);
        System.out.println();

        System.out.println("Instrutor montando o treino");
        List<Exercicio> fichaExercicios = new ArrayList<>();
        Exercicio ex1 = new Exercicio("Supino Reto", 4, 10);
        Exercicio ex2 = new Exercicio("Agachamento Livre", 4, 12);
        Exercicio ex3 = new Exercicio("Pull-up", 3, 12);
        fichaExercicios.add(ex1);
        fichaExercicios.add(ex2);
        fichaExercicios.add(ex3);

        instrutor1.montarTreino(aluno1, "Hipertrofia com foco na parte superior", fichaExercicios);
        System.out.println();

        aluno1.visualizarTreinoAtual();
        System.out.println();

        System.out.println("Iniciando a aula extra com presença");

        AulaExtra aulaPilates = new AulaExtra("Pilates", 1);

        aulaPilates.inscreverAluno(aluno1);

        // para testar quando o aluno tenta se inscrever e nao tem vaga
        aulaPilates.inscreverAluno(aluno2);

        // instrutor grava a presença
        instrutor1.presenca(aluno1, aulaPilates);
        
        // para verificar se o instrutor tentar marcar a presença 2x
        instrutor1.presenca(aluno1, aulaPilates);
        System.out.println();

        System.out.println("Inspeção dos equipamentos");
        Equipamento esteira = new Equipamento("Esteira 01");
        unidadeCentro.adicionarEquipamento(esteira);

        instrutor1.registrarManutencao(esteira);
        System.out.println("Esteira em manutenção? " + esteira.isEmManutencao());
        
        instrutor1.liberarEquipamento(esteira);
        System.out.println("Esteira em manutenção? " + esteira.isEmManutencao());
        System.out.println();

        System.out.println("Sistema financeiro e verificando status de pagamento");
        Financeiro financeiro = new Financeiro();
        
        System.out.println("Pagamento em dia");
        financeiro.processarPagamento(aluno1, true);
        System.out.println();
        System.out.println("Status de inadimplência: " + aluno1.isInadimplente());
        System.out.println();
        
        System.out.println("Atraso de 3 meses no plano mensal");
        // alteramos a data da matricula para 3 meses atras
        aluno1.setDataMatricula(LocalDate.now().minusMonths(3));
        financeiro.processarPagamento(aluno1, false);
        System.out.println();
        System.out.println("Status de inadimplência: " + aluno1.isInadimplente());
        //nesse caso sera cobrado a multa referente a 2 meses
        System.out.println();
        
        System.out.println("Pagando a dívida");
        financeiro.processarPagamento(aluno1, true);
        System.out.println();
        System.out.println("Status de inadimplência: "+ aluno1.isInadimplente());
        System.out.println();
        
        System.out.println("Instrutor tentando fazer avaliação física antes de completar 1 mês");
        instrutor1.realizarAvaliacaoFisica(aluno2, 60.0, 20.0, 30.0);
        System.out.println("Histórico de avaliações da Ana: " + aluno2.getHistoricoAvaliacoes().size());
        System.out.println();

        System.out.println("Instrutor fazendo avaliação física no aluno Lucas que ja possui mais de 1 mes de matrícula");
        // colocamos o valor da data da ultima matricula de lucas para 1 mes atras
        aluno1.getHistoricoAvaliacoes().get(0).setDataAvaliacao(LocalDate.now().minusMonths(1));
        instrutor1.realizarAvaliacaoFisica(aluno1, 74.0, 16.5, 42.0);
        System.out.println("Histórico de avaliações do Lucas: " + aluno1.getHistoricoAvaliacoes().size());
        System.out.println();
        
        System.out.println("Administrador mudando o preço base");
        System.out.println();
        admin.definirPrecoPlano(aluno1.getPlano(), 120.00);
        System.out.println("Novo valor do plano do Lucas: " + (aluno1.getPlano().getValidadeMeses() * aluno1.getPlano().calcularMensalidade()));
        System.out.println("Novo valor do plano da Ana: " + (aluno2.getPlano().getValidadeMeses() * aluno2.getPlano().calcularMensalidade()));
        System.out.println();
        
        System.out.println("Demissao de funcionario (Atendente)");
        admin.demitirAtendente(unidadeCentro, atendente1);
        System.out.println();

        System.out.println("Finalizando teste");
    }
}