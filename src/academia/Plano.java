package academia;

public abstract class Plano {
	//o valor base é igual pra todos
	private static double valorBase = 100.0;


	public abstract double calcularMensalidade();
    
    public abstract int getValidadeMeses();

    // a multa é a mesma para todos, então já deixei pronta
    public double calcularMulta(int mesesAtraso) {
        return 30.0 * mesesAtraso;
    }
    public double getValorBase() {
		return valorBase;
	}

	public static void setValorBase(double valorNovo) {
		valorBase = valorNovo;
	}
}

