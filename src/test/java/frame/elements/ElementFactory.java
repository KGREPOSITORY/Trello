package frame.elements;

import org.openqa.selenium.By;

public class ElementFactory {
    private static ElementFactory elementFactory;

    public Button getButon(By locator){
        return new Button(locator);
    }


    public TextField getTextField(By locator){
        return new TextField(locator);
    }


    public static ElementFactory getElementFactory(){
        if(elementFactory ==null){
            elementFactory = new ElementFactory();
        }
        return elementFactory;
    }
}
