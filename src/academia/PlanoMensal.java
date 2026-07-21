package academia;

public class PlanoMensal extends Plano{
	
	@Override
    public double calcularMensalidade() {
        
        return getValorBase();
    }
	@Override
	public int getValidadeMeses() {
		return 1;
	}
}
