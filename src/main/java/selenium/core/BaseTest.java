package selenium.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import selenium.pages.LoginPage;

import java.io.IOException;

import static selenium.core.DriverFactory.killDriver;

public class BaseTest {

    private LoginPage page = new LoginPage();

    @Rule
    public TestName testName = new TestName();

    /**
     *  o trecho do @Before foi comentado por conta que durante a execucao da SuiteTests
     *  esse Before era responsavel por abrir o login da pagina toda vez que iniciava-se
     *  um novo teste. Va para a classe SuiteTests, la tem um @BeforeClass que eh responsavel
     *  por fazer esse login agora.
     *
     *  Caso precise executar um teste individualmente, descomente esse trecho e execute o teste,
     *  apos isso, comente esse trecho novamente.
     * **/
    @Before
    public void initializer() {
        page.accessHomePage();

        page.setEmail("matheus69@gmail.com");
        page.setPassword("1111");

        page.clickButtonEnter();
    }

    @After
    public void finalizeWebDriver() throws IOException {
//        Arrumar isso
//        TakesScreenshot ss = (TakesScreenshot) getDriver();
//        File arquivo = ss.getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" +
//                File.separator + testName.getMethodName() + ".jpg"));

        /**
         * Verificação da propriedade -> Properties.class
         *
         * Para não fechar os WebDriver dos testes que herdam esta Classe (BaseTest)
         * para assim abrir apenas uma instancia do WebDriver e acelerar os testes.
         *
         * OBS: NÃO RECOMENDADO, USADO APENAS PARA FINS DIDÁTICOS
         **/
        if (Properties.CLOSE_BROWSER) {
            killDriver();
        }
    }


}
