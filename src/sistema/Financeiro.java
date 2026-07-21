package sistema;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import academia.Aluno;
import academia.Plano;

// Sistema financeiro

public class Financeiro {

    public void processarPagamento(Aluno aluno, boolean pagamentoEfetuado) {
        System.out.println("Fatura do aluno: " + aluno.getNome());
        
        // pegamos o plano do aluno
       
        Plano planoAluno = aluno.getPlano();
        
        // calculamos o tempo desde a matricula
        int mesesDesdeMatricula = (int) ChronoUnit.MONTHS.between(aluno.getDataMatricula(), LocalDate.now());
        
        // os meses de acordo com o plano
        int validadeDoPlano = planoAluno.getValidadeMeses();
        
        // o atraso só acontece se o tempo decorrido for maior que o plano que foi contratado
        int mesesAtraso = 0;
        if (mesesDesdeMatricula > validadeDoPlano) {
            mesesAtraso = (int) (mesesDesdeMatricula - validadeDoPlano);
        }
        
        // atualiza o status de inadimplência
        if (mesesAtraso > 0) {
            aluno.setInadimplente(true);
            System.out.println("Esta inadimplente.");
        } else {
            System.out.println("Esta adimplente.");
        }

        double valorMensalidade = planoAluno.calcularMensalidade();
        double valorMulta = planoAluno.calcularMulta(mesesAtraso); 
        double total= valorMensalidade + valorMulta;

        System.out.println("Valor da Mensalidade: " + valorMensalidade);
        System.out.println("Valor da Multa: " + valorMulta);
        System.out.println("Total a ser pago: " + total);
        
        if (pagamentoEfetuado) {
            System.out.println("Pagamento recebido");
            aluno.setInadimplente(false); 
          
        } else {
            System.out.println("Pagamento recusado");
        }
    }
}