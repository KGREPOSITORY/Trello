package frame.elements;

import org.openqa.selenium.By;

public class TextField extends Element{

    public TextField(By locator) {
        super(locator);
    }

    public void clear(){
        webElement.clear();
    }

    public void celarAndType(String value){
        clear();
        webElement.sendKeys(value);
    }
}
