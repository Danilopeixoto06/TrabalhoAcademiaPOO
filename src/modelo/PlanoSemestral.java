package modelo;

public class PlanoSemestral extends Plano {
	
	@Override
    public double calcularMensalidade() {
       
        return valorBase - (valorBase * 0.10); 
    }
	@Override
	public int getValidadeMeses() {
		return 6;
	}
	
}
