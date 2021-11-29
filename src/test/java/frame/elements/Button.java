package frame.elements;

import org.openqa.selenium.By;

public class Button extends Element{

    public Button(By locator) {
        super(locator);
    }

    public void click(){
        webElement.click();
    }

    public void waitAndClick(){
        isElementDisplayed();
        click();
    }
}
