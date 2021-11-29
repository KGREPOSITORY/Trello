package frame;


import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver extends ChromeDriver {
    private static Driver driver;

     static {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
    }


    public void openPage(String url){
         driver.get(url);
    }

    public synchronized static Driver getDriver(){
        if (driver == null){
            driver = new Driver();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
            driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        }
        return driver;
    }


}
