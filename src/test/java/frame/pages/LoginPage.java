package frame.pages;

import frame.elements.Button;
import frame.elements.ElementFactory;
import frame.elements.TextField;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final TextField txtLogin = ElementFactory.getElementFactory().getTextField(By.xpath("//input[@id='user']"));
    private final TextField txtPassword = ElementFactory.getElementFactory().getTextField(By.xpath("//input[@id='password']"));
    private final Button btnPassword = ElementFactory.getElementFactory().getButon(By.xpath("//input[@id='login']"));


    public LoginPage enterLogin(String value){
        txtLogin.isElementDisplayed();
        txtLogin.celarAndType(value);
        return this;
    }

    public LoginPage enterPassword(String value){
        txtPassword.isElementDisplayed();
        txtPassword.celarAndType(value);
        return this;
    }

    public LoginPage clickEneter(){
        btnPassword.waitAndClick();
        return this;
    }

}
