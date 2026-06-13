package Modelo;

public class PlanoSemestral extends Plano {
	
	@Override
    public double calcularMensalidade() {
        // Aplica o desconto de 10%
        return valorBase - (valorBase * 0.10); 
    }
}
