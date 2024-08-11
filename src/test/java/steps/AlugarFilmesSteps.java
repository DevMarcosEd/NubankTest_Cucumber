package steps;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

import org.junit.Assert;

import entidades.Filme;
import entidades.NotaAluguel;
import entidades.TipoAluguel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import servicos.AluguelService;
import servicos.AluguelService.FilmeSemEstoqueException;
import utils.DateUtils;

public class AlugarFilmesSteps {
	
	private Filme filme;
	private AluguelService aluguelService = new AluguelService();
	private NotaAluguel nota;
	private TipoAluguel tipoAluguel;
	
	LocalDate dataCompra;
	LocalDate dataEntrega;
	
	// Dado que um filme tem um estoque de X unidades
	@Given("um filme com estoque de {int} unidades")
	public void umFilmeComEstoqueDeUnidades(Integer agr1) {
		filme = new Filme();
		filme.setEstoque(agr1);  // Define o estoque do filme
	}
	
	// Dado que o preço do aluguel é R$ X
	@Given("que o preço de aluguel seja R$ {int}")
	public void queOPreçoDeAluguelSejaR$(Integer int1) {
	    filme.setAluguel(int1);  // Define o preço do aluguel
	}

	// Quando alugar o filme
	@When("alugar")
	public void alugar() {
		 try {
		        nota = aluguelService.alugar(filme, tipoAluguel);  // Aluga o filme e recebe a nota de aluguel
		    } catch (FilmeSemEstoqueException e) {
		        nota = null; // Se ocorrer a exceção, define a nota como nula
		    }
	}

	// Então o preço do aluguel será R$ X
	@Then("o preço do aluguel será R$ {int}")
	public void oPreçoDoAluguelSeráR$(Integer int1) {
	    Assert.assertEquals(int1.intValue(), nota.getPreco());  // Verifica se o preço do aluguel está correto
	}
	
	// Implementação do step definition para o passo "Given um filme"
	@Given("um filme")
	public void umFilme(io.cucumber.datatable.DataTable table) {
	    // Converte a DataTable para um mapa onde a chave e o valor são Strings
	    Map<String, String> map = table.asMap(String.class, String.class);
	    // Cria uma nova instância de Filme
	    filme = new Filme();
	    // Define o estoque do filme a partir do valor no mapa
	    filme.setEstoque(Integer.parseInt(map.get("estoque")));
	    // Define o preço do aluguel do filme a partir do valor no mapa
	    filme.setAluguel(Integer.parseInt(map.get("preco")));
	    String tipo = map.get("tipo");
	    tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL: tipo.equals("extendido")? TipoAluguel.EXTENDIDO: TipoAluguel.COMUM;
	   
	}


	// Então o estoque do filme será X unidade(s)
	@Then("o estoque do filme será {int} unidade")
	public void oEstoqueDoFilmeSeráUnidade(Integer int1) {
	    Assert.assertEquals(int1.intValue(), filme.getEstoque());  // Verifica se o estoque do filme está correto
	}
	
	@Then("não será possível por falta de estoque")
	public void nãoSeráPossívelPorFaltaDeEstoque() {
	    try {
	        nota = aluguelService.alugar(filme, tipoAluguel);
	        // Se chegou aqui sem lançar exceção, falha o teste
	        throw new AssertionError("Expected FilmeSemEstoqueException to be thrown");
	    } catch (FilmeSemEstoqueException e) {
	        // Verifica se a mensagem da exceção está correta
	        assertEquals("Filme sem estoque disponível.", e.getMessage());
	        
	        // Verifica se o estoque do filme ainda é zero após tentar alugar sem estoque
	        assertEquals(0, filme.getEstoque());
	    }
	}
	
	@Given("que o tipo do aluguel seja (.*)$")
	public void queOTipoDoAluguelSejaExtendido(String tipo) {
		tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL: tipo.equals("extendido")? TipoAluguel.EXTENDIDO: TipoAluguel.COMUM;
	}

	@Then("a data de entrega será em {int} dias")
	public void aDataDeEntregaSeráEmDias(int int1) {

		Date dataEsperada = DateUtils.obterDataDiferencaDias(int1);
		Date dataReal = nota.getDataEntrega();
		
	    // Formata as datas para "dd/MM/yyyy"
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    String dataEsperadaStr = sdf.format(dataEsperada);
	    String dataRealStr = sdf.format(dataReal);
		
	    //System.out.println("Esperada" + dataEsperadaStr + "Real: " + dataRealStr);
		assertEquals(dataEsperadaStr, dataRealStr);
	}
	
	@Then("a pontuação recebida será de {int} pontos")
	public void aPontuaçãoRecebidaSeráDePontos(int int1) {
	    assertEquals(int1, nota.getPontuacao());
	}
	
}
