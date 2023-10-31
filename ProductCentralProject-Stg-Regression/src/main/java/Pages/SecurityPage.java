
package Pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;

public class SecurityPage extends HelperFunctions {
	public SecurityPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		} 
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement pageTitle;
	
	@FindBy(xpath="//div[@class='cmp-legal-product-listing__tiles']")
	private static List<WebElement> securityTiles;
	
	@FindBy(xpath="//div[@id='productListingDropdown']")
	private WebElement productListingDropdown;
	
	@FindBy(xpath="//div[@id='sortingDropdown']")
	private WebElement sortingDropdown;
	
	@FindBy(xpath="//div[@class='cmp-legal-product-listing__tiles']//a")
	private static List<WebElement> securityTiles2;
	
	static Logger logger=Logger.getLogger("SecurityPage");
	
	public void setSecurityTiles() {
		HelperFunctions.waitForPageToLoad(5);
		
		boolean isAllDisplayed = true;
        for(WebElement eachTiles : securityTiles){ 
            if(eachTiles.isDisplayed() == false){
                isAllDisplayed = false;
                break;
            }
        }
       
       HelperFunctions.staticWait(3);
       Boolean pld=productListingDropdown.isDisplayed();
       System.out.println("Product Listing Dropdown is displayed  :" + pld);
       HelperFunctions.staticWait(3);
       Boolean sd=sortingDropdown.isDisplayed();
       System.out.println("Sorting Dropdown is displayed  :" + sd);
     
	}
	public void setProductNameLength() {
		HelperFunctions.waitForPageToLoad(5);
	
		for (WebElement product : securityTiles2) {
			  String productNameText = product.getText();
			  int productNameWidth = product.getSize().getWidth();
			  int productNameLength = productNameText.length();

			  if (productNameLength > productNameWidth) {
			    String ellipses = productNameText.substring(productNameLength - 3, productNameLength);
			    Assert.assertEquals(ellipses, "...");
			  } else {
			    Assert.assertTrue(true); 
			  }
			}
     
	}
	
	public void setProductAlignment() {
		HelperFunctions.waitForPageToLoad(5);
	
		for (WebElement product : securityTiles2) {
		   
		    WebElement parentElement = product.findElement(By.xpath("./*"));
		    int parentHeight = parentElement.getSize().getHeight();

		    WebElement productNameElement = product.findElement(By.cssSelector("span"));
		    int productNameHeight = productNameElement.getSize().getHeight();

		 
		    int productNameMarginTop = Integer.parseInt(productNameElement.getCssValue("margin-top").replaceAll("[^0-9]", ""));

		   
		    int productNameMarginBottom = Integer.parseInt(productNameElement.getCssValue("margin-bottom").replaceAll("[^0-9]", ""));

		    
		    int totalProductNameHeight = productNameHeight + productNameMarginTop + productNameMarginBottom;

		   
		    int expectedMarginTop = (parentHeight - totalProductNameHeight) / 2;
		    int actualMarginTop = productNameMarginTop;
		    Assert.assertEquals(expectedMarginTop, actualMarginTop);
		}
	}
	public void setTilesHeight() {
		HelperFunctions.waitForPageToLoad(5);
	
		int previousHeight = -1;

		for (WebElement product : securityTiles2) {
	
		    int currentHeight = product.getSize().getHeight();

	
		    if (previousHeight > 0) {
		        Assert.assertEquals(previousHeight, currentHeight);
		    }

		
		    previousHeight = currentHeight;
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
