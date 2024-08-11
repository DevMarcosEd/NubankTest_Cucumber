package entidades;

public class Filme {
	private int estoque;
	private int aluguel;

	// Define o estoque do filme
	public void setEstoque(int arg1) {
		this.estoque = arg1;
	}
	
	// Define o preço do aluguel do filme
	public void setAluguel(int arg1) {
		this.aluguel = arg1;
	}
	
	// Retorna o preço do aluguel do filme
	public int getAluguel() {
		return aluguel;
	}

	// Retorna o estoque do filme
	public int getEstoque() {
		return estoque;
	}
}
