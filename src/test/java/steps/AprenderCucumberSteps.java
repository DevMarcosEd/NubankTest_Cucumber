package steps;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AprenderCucumberSteps {
	
	@Given("que criei o arquivo corretamente")
	public void queCrieiOArquivoCorretamente() {
		
	}

	@When("executá-lo")
	public void executáLo() {

	}

	@Then("a especificação deve finalizar com sucesso")
	public void aEspecificaçãoDeveFinalizarComSucesso() {

	}
	
	private int contador = 0;
	
	@Given("que o valor do contador é {int}")
	public void queOValorDoContadorÉ(Integer int1) {
	     contador = int1;
	}

	@When("eu incrementar em {int}")
	public void euIncrementarEm(Integer int1) {
	    contador = contador + int1;
	}

	@Then("o valor do contador será {int}")
	public void oValorDoContadorSerá(int int1) {
		//Assert.assertTrue(int1 == contador);
		Assert.assertEquals(int1, contador);
	}
	
	Date entrega = new Date();
	
	@Given("que o prazo é dia {int}\\/{int}\\/{int}")
	public void queOPrazoÉDia(Integer arg1, Integer arg2, Integer arg3) {
	    	Calendar cal = Calendar.getInstance();
	    	cal.set(Calendar.DAY_OF_MONTH, arg1);
	    	cal.set(Calendar.MONTH, arg2 - 1);
	    	cal.set(Calendar.YEAR, arg3);
	    	entrega = cal.getTime();
	}

	@When("a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
	public void aEntregaAtrasarEmDias(Integer dia, String tempo) {
	   Calendar cal = Calendar.getInstance();
	   cal.setTime(entrega);
	   if(tempo.equals("dias")) {
		   cal.add(Calendar.DAY_OF_MONTH, dia);
	   }
	   if(tempo.equals("meses")) {
		   cal.add(Calendar.MONTH, dia);
	   }
	   entrega = cal.getTime();
	}

	@Then("a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void aEntrefaSeráEfetuadaEm(String data) {
	   DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	   String dataFormatada = format.format(entrega);
	   Assert.assertEquals(data, dataFormatada);
	   
	}
	
	@Given("que o ticket(?: especial)? é (AB|AF)\\d{3}$")
	public void queOTicketÉAF(String prefixo) {
	}
	
	@And("que o valor da passagem é R$ {double}")
	public void queOValorDaPassagemÉR$(Double double1) {
		
	}

	@And("que o nome do passageiro é \"([A-Za-z ]{1,20})\"$")
	public void queONomeDoPassageiroÉ(String string) {

	}

	@And("que o telefone do passageiro é {int}{int}")
	public void queOTelefoneDoPassageiroÉ(Integer int1, Integer int2) {

	}

	@When("criar os steps")
	public void criarOsSteps() {

	}

	@Then("o teste vai funcionar")
	public void oTesteVaiFuncionar() {

	}

}
