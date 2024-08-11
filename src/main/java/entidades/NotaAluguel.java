package entidades;

import java.util.Date;

public class NotaAluguel {

	private int preco;
	private Date dataEntrega;
	private Date DataCompra;
	private int pontuacao;
	
	// Retorna o preço do aluguel
	public int getPreco() {
		return preco;
	}

	// Define o preço do aluguel
	public void setPreco(int preco) {
		this.preco = preco;
	}
	
	// Retorna a data de entrega
	public Date getDataEntrega() {
		return dataEntrega;
	}

	// Define a data de entrega
	public void setDataEntrega(Date time) {
		dataEntrega = time;
	}

	public Date getDataCompra() {
		return DataCompra;
	}

	public void setDataCompra(Date time) {
		DataCompra = time;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
}