package selenium.pages;

import selenium.core.BasePage;

public class MenuPage extends BasePage {

    public void accessScreenHome() {
        clickLink("Home");
    }

    public void accessAccountOption() {
        clickLink("Contas");
    }

    public void accessAccountOptionAdd() {
        clickLink("Adicionar");
    }

    public void accessAccountOptionLister() {
        clickLink("Listar");
    }

}
