package steps;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CadastrarContaSteps {
	
	private WebDriver driver;
	
	@Given("que estou acessando a aplicação")
	public void queEstouAcessandoAAplicação() {
		System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://nubank.com.br/");
	}

	@Given("Que preencho os dados de cadastro com cpf {string}, nome {string}, celular {string}, email {string}")
	public void quePreenchoOsDadosDeCadastroComCpfNomeCelularEmail(String cpf, String nome, String celular, String email) {
    	driver.findElement(By.id("field-cpf")).sendKeys(cpf);
    	driver.findElement(By.id("test")).click();
    	driver.findElement(By.id("field-name")).sendKeys(nome);
    	driver.findElement(By.id("field-phone")).sendKeys("69995577502");
    	driver.findElement(By.id("field-email")).sendKeys(email);
	    driver.findElement(By.id("field-emailConfirmation")).sendKeys(email);
	}
	
	@And("Marco a confirmação do ceckbox")
	public void marcoAConfirmaçãoDoCeckbox() {
	    driver.findElement(By.id("label-accepted")).click();
	}
	
	@And("clico no botão enviar")
	public void clicoNoBotãoEnviar() {
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
	}

	@Then("A conta e criada com sucesso")
	public void aContaECriadaComSucesso() {
	    
	}
	
    @When("informo um cpf invalido {string}")
    public void informoUmCpfInvalido(String cpf) {
        WebElement cpfField = driver.findElement(By.id("field-cpf"));
        cpfField.sendKeys(cpf);

        // Simular clique fora do campo para disparar a validação
        WebElement body = driver.findElement(By.tagName("body"));
        body.click();
    }
    
    @Then("sou notificado que o cpf é inválido")
    public void souNotificadoQueOCpfÉInválido() {
        String textoErro = driver.findElement(By.id("error-cpf")).getText();
        assertEquals("Precisamos de um CPF válido.", textoErro);
    }
    
    @Given("informo um cpf {string}")
    public void informoUmCpf(String cpf) {
        driver.findElement(By.id("field-cpf")).sendKeys(cpf);
        driver.findElement(By.id("test")).click();
    }

    @When("informo um nome {string}")
    public void informoUmNome(String string) {
    	driver.findElement(By.id("field-name")).sendKeys(string);
    }
    
    @Then("sou notificado que preciso informar o nome completo")
    public void souNotificadoQuePrecisoInformarONomeCompleto() {
        WebElement body = driver.findElement(By.tagName("body"));
        body.click();
        
        String textoErro = driver.findElement(By.id("error-name")).getText();
        assertEquals("Precisamos do seu nome completo.", textoErro); 
    }
    
    @After(order = 1)
    public void screenshot(Scenario cenario) {
        // Verifica se o driver está inicializado
        if (driver instanceof TakesScreenshot) {
            // Captura a tela e obtém o arquivo temporário
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            
            // Garante que o diretório de destino exista
            File screenshotDir = new File("target/screenshot/");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }
            
            // Define o caminho do arquivo de destino
            File destinationFile = new File("target/screenshot/" + cenario.getName() + ".jpg");
            
            try {
                // Copia o arquivo de captura para o destino
                FileUtils.copyFile(file, destinationFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("O driver não suporta captura de tela.");
        }
    }
	@After(order = 0)
	public void finished() {
		driver.quit();
	}

}