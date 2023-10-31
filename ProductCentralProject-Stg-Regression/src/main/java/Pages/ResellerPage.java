package Pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pwc.productcentral.Driver;
import com.pwc.productcentral.HelperFunctions;

public class ResellerPage extends HelperFunctions {
	public ResellerPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		}
	
	@FindBy(xpath="//h1[@class='cmp-title__text']")
	private WebElement pageTitle;
	
	@FindBy(xpath="//a[@href='/us/en/automation/reseller-demo/check-in.html']")
	private WebElement checkInLink;
	
	@FindBy(xpath="//a[@href='/us/en/automation/reseller-demo/dragos-alliance.html']")
	private WebElement complianceLink;
	
	@FindBy(xpath="//a[@href='/us/en/automation/reseller-demo/microsoft-alliance.html']")
	private WebElement microsoftAllianceLink;
	
	@FindBy(xpath="//div[@class='cmp-product-list__cards-container']//a")
	private static List<WebElement> productList;
	
	@FindBy(xpath="//a[@href='/us/en/automation/reseller-demo/check-in/resell-offering-overview.html']")
	private WebElement resellOfferingOverviewLink;
	
	@FindBy(xpath="//span[@class='cmp-pdf-highlights__title']")
	private WebElement resellOfferingOverviewTitle;
	
	@FindBy(xpath="//a[@href='/content/pc/us/en/automation/reseller-demo/check-in.html']")
	private WebElement backtoCheckinBreadcrumb;
	
	@FindBy(xpath="//a[@href='/content/pc/us/en/automation/reseller-demo.html']")
	private WebElement backtoResellerDemoBreadcrumb;
	
	@FindBy(xpath="//div[@class='cmp-breadcrumb']//a")
	private static List<WebElement> breadcrumbLinks;
	
	@FindBy(xpath="//div[@class='cmp-product-list__cards-container']//a")
	private static List<WebElement> tiles;
	
	@FindBy(xpath="//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")
	private static WebElement closeButtonforCookies;
	
	@FindBy(xpath="//div[@class='cmp-document-tiles__entries']//a[1]")
	private WebElement firstTile;
	
	@FindBy(xpath="//h1[contains(@class, 'title')]")
	private WebElement contentTitle;
	
	@FindBy(xpath="//div[@class='cmp-breadcrumb']//a")
	private WebElement breadcrumb;
	
	
	
	static Logger logger=Logger.getLogger("ResellerPage");
	
	
	public void setBreadcrumbs() {
		
		HelperFunctions.waitForPageToLoad(5);
		for(WebElement link:productList) {
			link.click();
			break;
		}
		HelperFunctions.waitForPageToLoad(5);
		
		 for (WebElement link : breadcrumbLinks) {
			 String hrefValue = link.getAttribute("href");
			 link.click();
			 String currentUrl = Driver.getDriver().getCurrentUrl();
			 Assert.assertEquals(hrefValue, currentUrl);
	            }
		
	}
	
	public void setPageTitleAndProducts() {
		HelperFunctions.waitForPageToLoad(3);
		Assert.assertTrue(pageTitle.isDisplayed());
		
		  for (WebElement link : productList) {
	            
              String href = link.getAttribute("href");

          
              if (!href.isEmpty()) {
            
                  System.out.println(href);
                  Assert.assertTrue(true);
              }else {
            	  Assert.assertTrue(false);
              }
          }
		
	
	}
	public void setZeroTiles() throws Exception {
		HelperFunctions.waitForPageToLoad(5);
		HelperFunctions.staticWait(2);

		 HelperFunctions.staticWait(2);
		 for (int i = 0; i < 2; i++) {
			 if (!tiles.get(i).isDisplayed()) {
				  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	                js.executeScript("arguments[0].scrollIntoView(true);", tiles.get(i));
	                try {
	                    Thread.sleep(1000); 
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
			 
			 
			 tiles.get(i).click();
	            if (firstTile.isDisplayed()) {
	                System.out.println("Tile displayed for element " + i);
	            } else {
	                System.out.println("Tile not displayed for element " + i);
	            }
	          
	            Driver.getDriver().navigate().back();
	        }
		HelperFunctions.waitForPageToLoad(5);
		
	}
	
	public void setContentPageOpensSameTab() throws Exception {
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(2);
        tiles.get(0).click();
        HelperFunctions.waitForPageToLoad(15);
        if (firstTile.isDisplayed()) {
        	firstTile.click();
        }
        HelperFunctions.waitForPageToLoad(15);
        HelperFunctions.staticWait(1);
        if(contentTitle.isDisplayed()) {
        	 Assert.assertTrue(true);
        }else {
        	String errorMessage = "Content page did not open in the same tab";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
        }
		
	}
	public void setBreadcrumbs2() throws Exception {
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(2);
        tiles.get(0).click();
        HelperFunctions.waitForPageToLoad(15);
        if (firstTile.isDisplayed()) {
        	firstTile.click();
        }
        HelperFunctions.waitForPageToLoad(15);
        HelperFunctions.staticWait(1);
        if(contentTitle.isDisplayed()) {
        	 Assert.assertTrue(true);
        }else {
        	String errorMessage = "Content page did not open";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
        }
        HelperFunctions.staticWait(1);
        breadcrumb.click();
        HelperFunctions.waitForPageToLoad(15);
        Assert.assertTrue(firstTile.isDisplayed());
        breadcrumb.click();
        HelperFunctions.waitForPageToLoad(15);
        Assert.assertTrue(tiles.get(0).isDisplayed());
        HelperFunctions.staticWait(1);
	}
	public void setBreadcrumbsHierarchy() throws Exception {
		HelperFunctions.waitForPageToLoad(15);
		HelperFunctions.staticWait(2);
        tiles.get(0).click();
        HelperFunctions.waitForPageToLoad(15);
        if (firstTile.isDisplayed()) {
        	firstTile.click();
        }
        HelperFunctions.waitForPageToLoad(15);
        HelperFunctions.staticWait(1);
        if(contentTitle.isDisplayed()) {
        	 Assert.assertTrue(true);
        }else {
        	String errorMessage = "Content page did not open";
	        logger.error(errorMessage);
	        throw new Exception(errorMessage);
        }
        HelperFunctions.staticWait(1);
        breadcrumb.click();
        HelperFunctions.waitForPageToLoad(15);
        Assert.assertTrue(firstTile.isDisplayed());
        breadcrumb.click();
        HelperFunctions.waitForPageToLoad(15);
        Assert.assertTrue(tiles.get(0).isDisplayed());
        HelperFunctions.staticWait(3);
	}
	public void setTilesPerDocument() throws Exception {
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(2);
Driver.getDriver().get("https://productcentral-qa.products.pwc.com/us/en/resell-alliances.html");
HelperFunctions.waitForPageToLoad(30);
HelperFunctions.staticWait(2);
		 //HelperFunctions.staticWait(2);
		 for (int i = 0; i < 1; i++) {
			 if (!tiles.get(i).isDisplayed()) {
				  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
	                js.executeScript("arguments[0].scrollIntoView(true);", tiles.get(i));
	                try {
	                    Thread.sleep(1000); 
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
			 
			 
			 tiles.get(i).click();
			 HelperFunctions.waitForPageToLoad(30);
	            if (firstTile.isDisplayed()) {
	                System.out.println("Tile displayed for element " + i);
	            } else {
	                System.out.println("Tile not displayed for element " + i);
	            }
	          
	            Driver.getDriver().navigate().back();
	        }
		HelperFunctions.waitForPageToLoad(30);
		HelperFunctions.staticWait(3);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
