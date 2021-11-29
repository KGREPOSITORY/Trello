package frame.pages;

import frame.elements.Button;
import frame.elements.ElementFactory;
import frame.elements.TextField;
import org.openqa.selenium.By;

public class AtlassianLoginPage extends BasePage {
    private Button btnLogin = ElementFactory.getElementFactory().getButon(By.xpath("//button[contains(@id,'login')]"));
    private final TextField txtPassword = ElementFactory.getElementFactory().getTextField(By.xpath("//input[@id='password']"));


    public void clickLogin(){
        btnLogin.click();
    }

    public AtlassianLoginPage enterPassword(String value){
        txtPassword.isElementDisplayed();
        txtPassword.celarAndType(value);
        return this;
    }


}
