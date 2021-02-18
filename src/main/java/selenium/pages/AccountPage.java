package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import selenium.core.BasePage;
import selenium.exceptions.ElementNotFoundException;

public class AccountPage extends BasePage {

    public void insertAccountName(String name) {
        write("nome", name);
    }

    public void clickButtonSalvar() {
        clickButton(By.xpath(".//button[.='Salvar']"));
    }

    public String getMessageInsertAccountSucess() {
        return getTextComponent(By.xpath(".//div[@class='alert alert-success']"));
    }

    public String getMessageErrorInsertAccount() {
        return getTextComponent(By.xpath(".//div[@class='alert alert-danger']"));
    }

    public String getMessageAlertWelcomeSucess() {
        return getTextComponent(By.xpath(".//div[@class='alert alert-success']"));
    }

}
