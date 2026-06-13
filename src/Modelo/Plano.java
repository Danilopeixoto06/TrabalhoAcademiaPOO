package Modelo;

public abstract class Plano {
	//o valor base é igual pra todos
	//protect para os filhos acessarem diretamente com o this
	protected double valorBase = 100.0;

    public abstract double calcularMensalidade();

    // a multa é a mesma para todos, então já deixei pronta
    public double calcularMulta(int mesesAtraso) {
        return 30.0 * mesesAtraso;
    }
}
