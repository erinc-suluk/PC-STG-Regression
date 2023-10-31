package com.pwc.productcentral;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class HelperFunctions{
	
    
    public static void staticWait(int second){
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void setWaitTime(){
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }



    public static void clickWithWait(WebElement webElement){

        Wait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(800))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(WebDriverException.class);

        WebElement element = (WebElement) wait.until((Function<WebDriver,WebElement>) driver -> webElement);

        try {
            element.click();
        }catch (WebDriverException e){
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

  
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

  
    public static void waitForPageTitle(String pageTitle) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.titleIs(pageTitle));
    }


   
    public static List<String> getListOfString(List<WebElement> listOfWebElements) {
        List<String> listOfStrings = new ArrayList<>();
        for (WebElement element : listOfWebElements) {
            String value = element.getText().trim();
            if (value.length() > 0) {
                listOfStrings.add(value);
            }
        }
        return listOfStrings;
    }


    public boolean switchWindow() {
        String parent_win = Driver.getDriver().getWindowHandle();
        Set<String> windows = Driver.getDriver().getWindowHandles();
        boolean flag =true ;
        for (String winID : windows) {

            if (!winID.equals(parent_win)) {
                Driver.getDriver().switchTo().window(winID);
                flag = true;
            }else {
                flag = false;
            }
        }
        return flag;
    }

    public static void scrollToElement(WebElement element){

        JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }


    public void switchFrame(String frameXpath) {
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath(frameXpath)));
    }


    public void waitForPresenceOfElement(By elementBy) {
        int timeout = Integer.parseInt(ConfigurationsReader.getProperties("waitTimeOut"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(elementBy));
    }


    public static void selectFromDropDown(WebElement element,String text){

        Select select = new Select(element);
        select.selectByVisibleText(text);
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

   
    private static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

    public static void enterText(WebElement element, String text){
        waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text); 
        wait.until(ExpectedConditions.attributeToBe(element, "value", text));
        System.out.println("Entering text: " + text);
    }
    
    public static String captureScreenshot(String fileName) {
    	TakesScreenshot takesScreenshot=(TakesScreenshot) Driver.getDriver();
    	File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
    	File destFile=new File("./Screenshots/"+fileName);
    	try {
    		FileUtils.copyFile(sourceFile, destFile);
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    	System.out.println("Screenshot was saved successfully");
    	return destFile.getAbsolutePath();
    }


}
