package cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import selenium.exceptions.ElementNotFoundException;
import selenium.pages.AccountPage;
import selenium.pages.LoginPage;
import selenium.pages.MenuPage;

import static selenium.core.DriverFactory.killDriver;

public class InserirContaStep {

    MenuPage menu = new MenuPage();
    LoginPage loginPage = new LoginPage();
    AccountPage accountPage = new AccountPage();

    @Dado("que estou acessando a aplicação")
    public void queEstouAcessandoAAplicação() {
        loginPage.accessHomePage();
    }

    @Quando("informo o usuário {string}")
    public void informoOUsuário(String strEmail) {
        loginPage.setEmail(strEmail);
    }

    @Quando("a senha {string}")
    public void aSenha(String strPassword) {
        loginPage.setPassword(strPassword);
    }

    @Quando("seleciono entrar")
    public void selecionoEntrar() {
        loginPage.clickButtonEnter();
    }

    @Então("visualizo a página inicial")
    public void visualizoAPáginaInicial() {
        try {
            Assert.assertEquals("Bem vindo, matheuscarv69!", accountPage.getMessageAlertWelcomeSucess());
        } catch (NoSuchElementException e) {
            String elementNotfound = e.getMessage().substring(42, 110);
            throw new ElementNotFoundException("Elemento não encontrado: " + elementNotfound);
        }
    }

    @Quando("seleciono Contas")
    public void selecionoContas() {
        menu.accessAccountOption();
    }

    @Quando("seleciono Adicionar")
    public void selecionoAdicionar() {
        menu.accessAccountOptionAdd();
    }

    @Quando("informo a conta {string}")
    public void informoAConta(String accountName) {
        accountPage.insertAccountName(accountName);
    }

    @Quando("seleciono Salvar")
    public void selecionoSalvar() {
        accountPage.clickButtonSalvar();
    }

    @Então("a conta é inserida com sucesso")
    public void aContaÉInseridaComSucesso() {
        try {
            Assert.assertEquals("Conta adicionada com sucesso!", accountPage.getMessageInsertAccountSucess());
        } catch (NoSuchElementException e) {
            String elementNotfound = e.getMessage().substring(42, 110);
            throw new ElementNotFoundException("Elemento não encontrado: " + elementNotfound);
        }
    }

    @After
    public void finalizeStep() {
        killDriver();
    }

}
