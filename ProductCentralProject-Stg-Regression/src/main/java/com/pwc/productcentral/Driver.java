package com.pwc.productcentral;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {
    
    private static ThreadLocal<WebDriver> driverPool=new ThreadLocal<>(); 

    private Driver (){
    }
    public static WebDriver getDriver(){
        if (driverPool.get() == null) {
            synchronized (Driver.class) {
                switch (ConfigurationsReader.getProperties("browser")) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        				DesiredCapabilities.chrome();
        				ChromeOptions options = new ChromeOptions();
        				options.addArguments("test-type");
        				options.addArguments("start-maximized");
        				options.addArguments("--js-flags=--expose-gc");
        				options.addArguments("--enable-precise-memory-info");
        				options.addArguments("--disable-popup-blocking");
        				options.addArguments("--disable-default-apps");
        				options.addArguments("--enable-automation");
        				options.addArguments("test-type=browser");
        				options.addArguments("disable-extensions");
        				options.setExperimentalOption("useAutomationExtension", false);
        				options.addArguments("--disable-notifications");
        				options.addArguments("chrome.switches", "--disable-extensions");
        				options.addArguments("--disable-save-password");
        				options.addArguments("disable-infobars");
        				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        break;
                    case "edge":
                        WebDriverManager.edgedriver().setup();
                        driverPool.set(new EdgeDriver());
                        break;
                    case "chrome-headless":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                        break;
                    default:
                        System.out.println("The Driver is NOT Found");

                }
            }
        }
        return driverPool.get();
    }
    public static void closeDriver(){
        if (driverPool.get()!=null){
            driverPool.get().quit();
            driverPool.remove();
        }

    }
}

