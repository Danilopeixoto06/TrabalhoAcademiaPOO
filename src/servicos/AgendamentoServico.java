package servicos;

import modelo.Aluno;
import modelo.AulaExtra;

//Sistema de agendamento

public class AgendamentoServico {

    public void matricularEmAula(Aluno aluno, AulaExtra aula) {
    	// verifica se ainda existem vagas na aula
        if (aula.getVagas() > 0) {
            // -1 vaga
            aula.setVagas(aula.getVagas() - 1);
            // Mensagem de validação
            System.out.println("Inscrição realizada!");
            System.out.println("Vagas restantes para " + aula.getTipo() + ": " + aula.getVagas());
        } else {
            // se não houver, bloqueia a inscrição
            System.out.println("Não foi possível realizar a inscrição.");
            System.out.println("A turma de " + aula.getTipo() + " já está lotada");
        }
    }
}