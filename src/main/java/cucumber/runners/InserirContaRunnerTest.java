package cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features/InserirConta.feature",
        glue = "cucumber.steps",
        tags = ("not @ignore"),
        plugin = {"pretty", "html:target/tests-report.html"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class InserirContaRunnerTest {


}
