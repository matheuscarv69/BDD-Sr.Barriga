package selenium.pages;

import selenium.core.BasePage;

public class MenuPage extends BasePage {

    public void accessScreenHome() {
        clickLink("Home");
    }

    public void accessScreenInsertAccount() {
        clickLink("Contas");
        clickLink("Adicionar");
    }

    public void accessScreenAccountOptions() {
        clickLink("Contas");
        clickLink("Listar");
    }

    public void accessScreenCreateMovement() {
        clickLink("Criar Movimentação");
    }

    public void accessScreenMonthlySummary() {
        clickLink("Resumo Mensal");
    }

}
