package frame.pages;


import frame.elements.Button;
import frame.elements.ElementFactory;
import org.openqa.selenium.By;

public class BasePage{
    private Button btnLogin = ElementFactory.getElementFactory()
            .getButon(By.xpath("//a[contains(@href,'login')]"));

    public BasePage clickLoginButton(){
        btnLogin.click();
        return this;
    }


}
