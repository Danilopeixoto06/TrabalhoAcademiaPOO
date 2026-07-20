package modelo;

public class PlanoAnual extends Plano{
	
	@Override
    public double calcularMensalidade() {

        return valorBase - (valorBase * 0.20);
    }
	
	@Override
	public int getValidadeMeses() {
		return 12;
	}
}
