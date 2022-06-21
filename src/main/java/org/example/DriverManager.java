package org.example;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class DriverManager extends Utils{
    LoadProp loadProp = new LoadProp();
    DesiredCapabilities capabilities = new DesiredCapabilities();
    public final String AUTOMATE_USERNAME = loadProp.getProperty("pragnabengediya_WQSR3a");
    public final String AUTOMATE_ACCESS_KEY = loadProp.getProperty("Y3dRX8kE6UfNStYDEv5N");
    public final String BrowserStackURL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    boolean cloud = Boolean.parseBoolean(System.getProperty("cloud"));
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Before method>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    String browserName = "Chrome";
   // String browserName = System.getProperty("browser");

    public void openBrowser() {
        //making decision cloud true or false
        //this will be run if cloud true (In cloud)
        if (cloud){
            //rin in could
            System.out.println("running cloud");
            if(browserName.equalsIgnoreCase("Chrome")) {

                capabilities.setCapability("browserName", "Chrome");
                capabilities.setCapability("browserVersion", "latest");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "11");
                capabilities.setCapability("bstack:options", browserstackOptions);
            }
            else if(browserName.equalsIgnoreCase("Safari")){
                capabilities.setCapability("os","OS X");
                capabilities.setCapability("os_version","Cataline");
                capabilities.setCapability("browser","Safari");
                capabilities.setCapability("browser_version","13.1");
                capabilities.setCapability("browserstack.local","false");
                capabilities.setCapability("browserstack.selenium_version","4.1.0");
            }
            else {
                System.out.println("Wrong Browser name or connection issue with bs");
            }
            try {
                driver= new RemoteWebDriver(new URL(BrowserStackURL),capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("running locally.......");
            if (browserName.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
               WebDriverManager.chromedriver().setup();
                //open Chrome browser
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver.exe");
                //open firefox browser
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("Edge")) {
                System.setProperty("webdriver.edge.driver", "src/test/java/drivers/msedgedriver.exe");
                //open firefox browser
                driver = new EdgeDriver();
            } else {
                System.out.println("Either your browser name is wrong or not provided : +browserName");
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://demo.nopcommerce.com/");
        }

   //public void closeBrowser(){
       // driver.quit();
       // }
        }}
