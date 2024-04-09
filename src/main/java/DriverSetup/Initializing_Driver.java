package DriverSetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Initializing_Driver {

    public static WebDriver ldriver;
    public WebDriver driver_init(String Browser){
        if(Browser.equals("chrome")){
            ldriver= WebDriverManager.chromedriver().create();

        }
        ldriver.manage().deleteAllCookies();
        ldriver.manage().window().maximize();
        return  ldriver;
    }

}
