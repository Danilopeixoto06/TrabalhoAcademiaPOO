package modelo;

public class PlanoMensal extends Plano{
	
	@Override
    public double calcularMensalidade() {
        // apenas retorna o valor base
        return valorBase;
    }
}
