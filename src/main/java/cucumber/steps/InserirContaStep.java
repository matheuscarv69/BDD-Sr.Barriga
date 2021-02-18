package cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import selenium.exceptions.ElementNotFoundException;
import selenium.exceptions.LoginException;
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
            Assert.assertTrue(accountPage.getMessageAlertWelcomeSucess().contains("Bem vindo"));
        } catch (NoSuchElementException e) {
            throw new LoginException("Não foi possível acessar a página home, verifique as credenciais");
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

    @Quando("informo a conta (.*)?$")
    public void informoAConta(String accountName) {
        accountPage.insertAccountName(accountName);
    }

    @Quando("seleciono Salvar")
    public void selecionoSalvar() {
        accountPage.clickButtonSalvar();
    }

    @Então("^recebo a mensagem (.*)?$")
    public void receboAMensagem(String msgExpected) {
        String msgAlert = accountPage.getMessageAlertGeneric();
        try {
            Assert.assertEquals(msgExpected, msgAlert);
        } catch (NoSuchElementException e) {
            String elementNotfound = e.getMessage().substring(42, 110);
            throw new ElementNotFoundException("Elemento não encontrado: " + elementNotfound);
        }
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


    @Então("sou notificado que o nome da conta é obrigatório")
    public void souNotificadoQueONomeDaContaÉObrigatório() {
        try {
            Assert.assertEquals("Informe o nome da conta", accountPage.getMessageErrorInsertAccount());
        } catch (NoSuchElementException e) {
            String elementNotfound = e.getMessage().substring(42, 110);
            throw new ElementNotFoundException("Elemento não encontrado: " + elementNotfound);
        }
    }

    @Então("sou notificado que já existe uma conta com esse nome")
    public void souNotificadoQueJáExisteUmaContaComEsseNome() {
        try {
            Assert.assertEquals("Já existe uma conta com esse nome!", accountPage.getMessageErrorInsertAccount());
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
