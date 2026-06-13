package modelo;

public class PlanoAnual extends Plano{
	
	@Override
    public double calcularMensalidade() {
        // Aplica o desconto de 20%
        return valorBase - (valorBase * 0.20);
    }
}
