package tests;

import frame.Driver;

import org.apache.logging.log4j.Level;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import utils.PropertyReader;



public class BaseTest extends Assert {
    protected static Logger logger = LogManager.getLogger();


    @BeforeSuite
    public void openMainPage(){
        logger.log(Level.INFO, "Prepare driver");
        Driver.getDriver().get(PropertyReader
                .getReader("C:\\Users\\anduser\\IdeaProjects\\Trello\\src\\test\\java\\resources\\URLData.properies")
                .getProperty("baceURL"));
    }


    @AfterSuite
    public void closeBrowser(){
        logger.log(Level.INFO,"Close browser");
        Driver.getDriver().quit();
    }

}
