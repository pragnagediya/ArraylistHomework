package org.example;


import com.sun.javafx.geom.Edge;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.time.Duration;

public class DriverManager extends Utils {

//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Before method>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    String browserName = "Chrome";
    public void openBrowser(){

    if (browserName.equalsIgnoreCase("Chrome")) {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        //open Chrome browser
        driver = new ChromeDriver();}

    else  if (browserName.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","src/test/java/drivers/geckodriver.exe");
        //open firefox browser
        driver = new FirefoxDriver();}
    else  if (browserName.equalsIgnoreCase("Edge")){
        System.setProperty("webdriver.edge.driver","src/test/java/drivers/msedgedriver.exe");
        //open firefox browser
        driver = new EdgeDriver();}
        else{
        System.out.println("Either your browser name is wrong or not provided : +browserName");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }
    public void closeBrowser()
{
    driver.quit();
}
}
