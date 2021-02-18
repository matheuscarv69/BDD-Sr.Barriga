package cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import selenium.exceptions.ElementNotFoundException;
import selenium.pages.AccountPage;
import selenium.pages.LoginPage;
import selenium.pages.MenuPage;

import java.io.File;
import java.io.IOException;

import static selenium.core.DriverFactory.getDriver;
import static selenium.core.DriverFactory.killDriver;

public class InserirContaDeclarativoStep {

    MenuPage menu = new MenuPage();
    LoginPage loginPage = new LoginPage();
    AccountPage accountPage = new AccountPage();

    @Dado("que desejo adicionar uma conta")
    public void queDesejoAdicionarUmaConta() {

        loginPage.accessHomePage();
        loginPage.setEmail("matheus69@gmail.com");
        loginPage.setPassword("1111");
        loginPage.clickButtonEnter();

        menu.accessAccountOption();
        menu.accessAccountOptionAdd();
    }

    @Quando("^adiciono uma (.*)?$")
    public void adicionoUmaConta(String accountName) {
        accountPage.insertAccountName(accountName);
        accountPage.clickButtonSalvar();
    }

    @Então("^recebo uma notificação: (.*)?$")
    public void receboUmaNotificação(String msgExpected) {
        String msgAlert = accountPage.getMessageAlertGeneric();
        try {
            Assert.assertEquals(msgExpected, msgAlert);
        } catch (NoSuchElementException e) {
            String elementNotfound = e.getMessage().substring(42, 110);
            throw new ElementNotFoundException("Elemento não encontrado: " + elementNotfound);
        }
    }


    // order 1 - executa antes do 0
    @After(order = 1)
    public void takeScreenshot(Scenario scenario) {
        File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("target/screenshots/" + scenario.getName() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // order 0 - executa depois do 1
    @After(order = 0)
    public void finalizeStep() {
        killDriver();
    }

}
