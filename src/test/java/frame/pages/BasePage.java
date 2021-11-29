package frame.pages;


import frame.Driver;
import frame.Logger;
import frame.elements.Button;
import frame.elements.ElementFactory;
import org.apache.logging.log4j.Level;
import org.openqa.selenium.By;
import org.testng.Assert;

@PageInfo("//body[@data-analytics-screen='homeScreen']")
public class BasePage{

    public BasePage(){
        Logger.getLogger().log(Level.INFO, "Check that "+this.getClass().getSimpleName() + " page is opened" );
        Assert.assertTrue(Driver.getDriver()
                .findElement(By.xpath(this.getClass().getAnnotation(PageInfo.class).value()))
                .isDisplayed());
    }

    private Button btnLogin = ElementFactory.getElementFactory()
            .getButon(By.xpath("//a[contains(@href,'login')]"));

    public BasePage clickLoginButton(){
        btnLogin.click();
        return this;
    }


}
