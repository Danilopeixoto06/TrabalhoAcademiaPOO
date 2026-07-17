package modelo;

public class AulaExtra {
	private String tipo;
	private int vagas;
	private final int LIMITE_MAXIMO = 30; 
	
	public AulaExtra (String tipo, int vagas) {
		this.tipo = tipo;
		this.setVagas(vagas); 
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
        if (vagas >= 0 && vagas <= LIMITE_MAXIMO) {
            this.vagas = vagas;
        } else {
            System.out.println("ERRO: Número de vagas inválido. O limite da sala é de " + LIMITE_MAXIMO + " pessoas.");
        }
    }
}