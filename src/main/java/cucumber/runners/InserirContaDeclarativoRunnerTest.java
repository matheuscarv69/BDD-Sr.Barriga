package cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import selenium.pages.HomePage;
import selenium.pages.LoginPage;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features/InserirContaDeclarativo.feature",
        glue = "cucumber.steps",
        tags = ("not @ignore"),
        plugin = {"pretty", "html:target/tests-report.html"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false
)
public class InserirContaDeclarativoRunnerTest {

    @BeforeClass
    public static void reset(){

        LoginPage loginPage = new LoginPage();
        loginPage.accessHomePage();
        loginPage.setEmail("matheus69@gmail.com");
        loginPage.setPassword("1111");
        loginPage.clickButtonEnter();

        HomePage homePage = new HomePage();
        homePage.clickButtonReset();
    }

}
