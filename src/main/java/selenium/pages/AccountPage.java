package selenium.pages;

import org.openqa.selenium.By;
import selenium.core.BasePage;

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

    public String getMessageAlertGeneric() {
        return getTextComponent(By.xpath(".//div[starts-with(@class,'alert alert-')]"));
    }

}
