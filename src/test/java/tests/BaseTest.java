package tests;

import frame.Driver;
import frame.Logger;
import org.apache.logging.log4j.Level;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.PropertyReader;



public class BaseTest extends Assert {
    @BeforeSuite
    public void openMainPage(){
        Logger.getLogger().log(Level.INFO, "Prepare driver");
        Driver.getDriver().get(PropertyReader
                .getReader("C:\\Users\\anduser\\IdeaProjects\\Trello\\src\\test\\java\\resources\\URLData.properies")
                .getProperty("baceURL"));
    }


    @AfterSuite
    public void closeBrowser(){
        Logger.getLogger().log(Level.INFO,"Close browser");
        Driver.getDriver().quit();
    }

}
