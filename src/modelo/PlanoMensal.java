package modelo;

public class PlanoMensal extends Plano{
	
	@Override
    public double calcularMensalidade() {
        
        return valorBase;
    }
	@Override
	public int getValidadeMeses() {
		return 1;
	}
}
