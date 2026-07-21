package academia;

public class PlanoSemestral extends Plano {
	
	@Override
    public double calcularMensalidade() {
       
        return getValorBase() - (getValorBase() * 0.10); 
    }
	@Override
	public int getValidadeMeses() {
		return 6;
	}
	
}
