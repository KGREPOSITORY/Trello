package frame.elements;

import frame.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class Element{
    protected WebElement webElement;

    public Element(By locator){
        webElement = Driver.getDriver().findElement(locator);
    }

    public boolean isElementDisplayed(){
        return new WebDriverWait(Driver.getDriver(), 100)
                .until(ExpectedConditions.elementToBeClickable(webElement)).isDisplayed();
    }

    public String getTextFromElement(){
        return webElement.getText();
    }

    public WebElement findChildElement(By locator){
        return webElement.findElement(locator);
    }

    public List<WebElement> findChildElements(By locator){
        return webElement.findElements(locator);
    }
}
