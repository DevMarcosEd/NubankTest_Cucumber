package servicos;

import entidades.Filme;
import entidades.NotaAluguel;
import entidades.TipoAluguel;
import utils.DateUtils;

public class AluguelService {
	
	// Método que realiza o aluguel do filme
	public NotaAluguel alugar(Filme filme, TipoAluguel tipo  ) {
		 if (filme.getEstoque() == 0) {
		        throw new FilmeSemEstoqueException("Filme sem estoque disponível.");
		}
		 
		 NotaAluguel nota = new NotaAluguel();
		 switch (tipo) {
		 case COMUM:
			 nota.setPreco(filme.getAluguel());  // Define o preço do aluguel na nota
			 nota.setDataCompra(DateUtils.obterDataDaCompra());
			 nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
			 nota.setPontuacao(1);
			 break;
		 case EXTENDIDO:
			 nota.setPreco(filme.getAluguel() * 2);
			 nota.setDataCompra(DateUtils.obterDataDaCompra());
			 nota.setDataEntrega(DateUtils.obterDataDiferencaDias(3));
			 nota.setPontuacao(2);
			 break;
		 case SEMANAL: 
			 nota.setPreco(filme.getAluguel() * 3);
			 nota.setDataCompra(DateUtils.obterDataDaCompra());
			 nota.setDataEntrega(DateUtils.obterDataDiferencaDias(7));
			 nota.setPontuacao(3);
			 break; 
		 }	
		
        // Reduz o estoque apenas se houver unidades disponíveis
        if (filme.getEstoque() > 0) {
            filme.setEstoque(filme.getEstoque() - 1);
        }
        
		return nota;
	}
	
	public class FilmeSemEstoqueException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public FilmeSemEstoqueException(String message) {
	        super(message);
	    }
	}
}
