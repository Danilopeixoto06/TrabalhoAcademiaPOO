package academia;

public class PlanoAnual extends Plano{
	
	@Override
    public double calcularMensalidade() {

        return getValorBase() - (getValorBase() * 0.20);
    }
	
	@Override
	public int getValidadeMeses() {
		return 12;
	}
}
