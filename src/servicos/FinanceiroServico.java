package servicos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import modelo.Aluno;
import modelo.Plano;

public class FinanceiroServico {

    public void processarPagamento(Aluno aluno, Plano plano, boolean pagamentoEfetuado) {
        System.out.println("\n--- Processando fatura para o aluno: " + aluno.getNome() + " ---");
        
        // meses atrasados
        long mesesAtraso = ChronoUnit.MONTHS.between(aluno.getDataMatricula(), LocalDate.now());
        
        // Atualiza o status do aluno
        if (mesesAtraso > 0) {
            aluno.setInadimplente(true);
            System.out.println("Status Inicial: INADIMPLENTE (" + mesesAtraso + " meses de atraso).");
        } else {
            System.out.println("Status Inicial: ADIMPLENTE (Em dia).");
        }

        // Calcula a mensalidade e a multa através do Polimorfismo
        double valorMensalidade = plano.calcularMensalidade();
        double valorMulta = plano.calcularMulta((int) mesesAtraso); 
        
        double totalAPagar = valorMensalidade + valorMulta;

        System.out.println("Valor da Mensalidade: R$ " + valorMensalidade);
        System.out.println("Valor da Multa: R$ " + valorMulta);
        System.out.println("TOTAL: R$ " + totalAPagar);
        
        // verificação
        if (pagamentoEfetuado) {
            System.out.println("Pagamento recebido pelo sistema!");
            aluno.setInadimplente(false); // Limpa o registo do aluno e liberta a catraca
        } else {
            System.out.println("\nPagamento foi recusado ou cancelado pelo aluno.");
            System.out.println("O acesso à academia permanece bloqueado.");
            // só muda se ele pagar
        }
    }
}