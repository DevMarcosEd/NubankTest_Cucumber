package runners;
//import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/cadastrar_conta.feature",
		glue = "steps",
		tags = "not @ignore",
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		stepNotifications = true,
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = true
		)
public class Runner {
	
	/*
	@BeforeClass
	public static void reset() {
		
	}
	*/
}