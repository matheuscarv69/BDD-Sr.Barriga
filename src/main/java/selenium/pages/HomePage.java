package selenium.pages;

import org.openqa.selenium.By;
import selenium.core.BasePage;

public class HomePage extends BasePage {

   public void clickButtonReset(){
       clickLink("reset");
   }

}
